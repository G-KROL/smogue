package com.wawcode.smogue.domain.api.item;

public interface BookCreateService {

    BookCreateDto createBook(String bookIsbn, BookCreateDto bookCreateDto);
}
