package com.wawcode.smogue.domain.item;

import com.wawcode.smogue.domain.api.item.BookDetailDto;
import com.wawcode.smogue.domain.api.item.BookDetailService;
import com.wawcode.smogue.domain.persistence.item.Book;
import com.wawcode.smogue.domain.persistence.item.BookRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookDetailServiceImpl implements BookDetailService {

    private static final Logger log = LoggerFactory.getLogger(BookDetailServiceImpl.class);

    private BookRepository bookRepository;
    private ModelMapper modelMapper;

    @Autowired
    public BookDetailServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDetailDto getBookDetails(String isbn) {
        Optional<Book> optionalBook = bookRepository.findBookByIsbn(isbn);
        Book book = optionalBook.orElseThrow(() -> new IllegalArgumentException("Book with given ISBN doesn't exist"));
        log.info("Book with {} ISBN was found", book.getIsbn());
        return convertToDto(book);
    }

    private BookDetailDto convertToDto(Book book) {
        return modelMapper.map(book, BookDetailDto.class);
    }
}
