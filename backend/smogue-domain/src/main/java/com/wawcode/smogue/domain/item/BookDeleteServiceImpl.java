package com.wawcode.smogue.domain.item;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wawcode.smogue.domain.api.item.BookDeleteService;
import com.wawcode.smogue.domain.persistence.item.Book;
import com.wawcode.smogue.domain.persistence.item.BookRepository;

import java.util.Optional;

@Service
public class BookDeleteServiceImpl implements BookDeleteService {

    private static final Logger log = LoggerFactory.getLogger(BookDeleteServiceImpl.class);

    private BookRepository bookRepository;

    @Autowired
    public BookDeleteServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public String deleteBook(String bookIsbn) {
        Optional<Book> optionalBook = bookRepository.findBookByIsbn(bookIsbn);
        Book book = optionalBook.orElseThrow(() -> new IllegalArgumentException("Book with given ISBN doesn't exist"));
        bookRepository.delete(book);
        log.info("Book with {} ISBN was deleted", book.getIsbn());
        return "Book with " + bookIsbn + " ISBN was deleted";
    }
}
