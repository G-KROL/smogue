package com.wawcode.smogue.domain.item;

import com.wawcode.smogue.domain.persistence.item.Book;
import com.wawcode.smogue.domain.persistence.item.BookRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wawcode.smogue.domain.api.item.BookEditDto;
import com.wawcode.smogue.domain.api.item.BookEditService;

import java.util.Optional;

@Service
public class BookEditServiceImpl implements BookEditService {

    private static final Logger log = LoggerFactory.getLogger(BookEditServiceImpl.class);
    private static final String DATABASE_USER = "library";

    private BookRepository bookRepository;
    private ModelMapper modelMapper;

    @Autowired
    public BookEditServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookEditDto edit(String isbn, BookEditDto bookEditDto) {
        Optional<Book> optionalBook = bookRepository.findBookByIsbn(isbn);
        Book book = optionalBook.orElseThrow(() -> new IllegalArgumentException("Book with given ISBN doesn't exist"));
        Book editedBook = getEditedBook(book, bookEditDto);
        bookRepository.save(editedBook);
        log.info("Book with {} ISBN was edited", editedBook.getIsbn());
        return convertToDto(editedBook);
    }

    private Book getEditedBook(Book book, BookEditDto bookEditDto) {
        book.edit(bookEditDto.getTitle(),
                bookEditDto.getNumberOfCopies(),
                bookEditDto.getCategory(),
                DATABASE_USER,
                bookEditDto.getPublisher(),
                bookEditDto.getPublishingDate(),
                bookEditDto.getNumberOfPages(),
                bookEditDto.getEdition());
        return book;
    }

    private BookEditDto convertToDto(Book editedBook) {
        return modelMapper.map(editedBook, BookEditDto.class);
    }
}
