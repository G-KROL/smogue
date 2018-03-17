package com.wawcode.smogue.domain.api.item;

import java.util.List;

public interface BookSearchService {

    List<BookListDto> searchBooksBySearchCriteria(List<BookSearchCriteriaDto> params);
}
