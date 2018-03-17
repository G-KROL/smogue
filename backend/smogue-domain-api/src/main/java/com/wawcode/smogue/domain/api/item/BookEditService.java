package com.wawcode.smogue.domain.api.item;

public interface BookEditService {

    BookEditDto edit(String isbn, BookEditDto bookEditDto);
}
