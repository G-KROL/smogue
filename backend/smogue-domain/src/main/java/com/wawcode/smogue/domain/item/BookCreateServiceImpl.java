package com.wawcode.smogue.domain.item;

import com.wawcode.smogue.domain.api.item.BookCreateDto;
import com.wawcode.smogue.domain.persistence.item.Author;
import com.wawcode.smogue.domain.persistence.item.AuthorRepository;
import com.wawcode.smogue.domain.persistence.item.Book;
import com.wawcode.smogue.domain.persistence.item.BookRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wawcode.smogue.domain.api.item.BookCreateService;

import java.util.Optional;

@Service
public class BookCreateServiceImpl implements BookCreateService {

    private static final Logger log = LoggerFactory.getLogger(BookCreateServiceImpl.class);
    private static final String DATABASE_USER = "library";

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private ModelMapper modelMapper;

    @Autowired
    public BookCreateServiceImpl(BookRepository bookRepository, ModelMapper modelMapper, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.authorRepository = authorRepository;
    }

    @Override
    public BookCreateDto createBook(String bookIsbn, BookCreateDto bookCreateDto) {
        Optional<Author> optionalAuthor = authorRepository.findAuthorByFirstNameAndLastName(bookCreateDto.getAuthorFirstName(), bookCreateDto.getAuthorLastName());
        Author author = optionalAuthor.orElseGet(() -> createAuthor(bookCreateDto));
        Book book = convertToEntity(author, bookIsbn, bookCreateDto);
        bookRepository.save(book);
        log.info("Book with Title {} was created", book.getTitle());
        return convertBookEntityToDto(book);
    }

    private Author createAuthor(BookCreateDto bookCreateDto) {
        log.info("Author of creating book doesn't exist, creating Author....");
        Author author = new Author(bookCreateDto.getAuthorFirstName(), bookCreateDto.getAuthorLastName(), DATABASE_USER);
        authorRepository.save(author);
        log.info("Author {} was created", author.getFirstName() + author.getLastName());
        return author;
    }

    private Book convertToEntity(Author author, String bookIsbn, BookCreateDto bookCreateDto) {
        return new Book(
                bookCreateDto.getTitle(),
                bookCreateDto.getNumberOfPages(),
                bookCreateDto.getCategory(),
                DATABASE_USER,
                bookCreateDto.getPublishingDate(),
                bookIsbn,
                bookCreateDto.getNumberOfPages(),
                bookCreateDto.getEdition(),
                author
        );
    }

    private BookCreateDto convertBookEntityToDto(Book book) {
        return modelMapper.map(book, BookCreateDto.class);
    }
}
