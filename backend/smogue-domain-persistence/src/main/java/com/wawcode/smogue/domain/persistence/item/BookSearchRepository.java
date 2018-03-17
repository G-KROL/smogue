package com.wawcode.smogue.domain.persistence.item;

import com.wawcode.smogue.domain.persistence.item.search.BookSearchCriteria;

import java.util.List;

public interface BookSearchRepository {

    List<Book> searchBooksBySearchCriteria(List<BookSearchCriteria> params);
}
