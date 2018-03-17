package com.wawcode.smogue.domain.item;

import com.wawcode.smogue.domain.api.item.BookListDto;
import com.wawcode.smogue.domain.api.item.BookSearchService;
import com.wawcode.smogue.domain.persistence.item.Book;
import com.wawcode.smogue.domain.persistence.item.BookSearchRepository;
import com.wawcode.smogue.domain.persistence.item.search.BookSearchCriteria;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wawcode.smogue.domain.api.item.BookSearchCriteriaDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class BookSearchServiceImpl implements BookSearchService {

    private static final Logger log = LoggerFactory.getLogger(BookSearchServiceImpl.class);
    private BookSearchRepository bookSearchRepository;
    private ModelMapper modelMapper;

    @Autowired
    public BookSearchServiceImpl(BookSearchRepository bookSearchRepository, ModelMapper modelMapper) {
        this.bookSearchRepository = bookSearchRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BookListDto> searchBooksBySearchCriteria(List<BookSearchCriteriaDto> params) {
        List<BookSearchCriteria> bookSearchCriteria = convertFromDtosToBookSearchCriteria(params);
        List<Book> books = bookSearchRepository.searchBooksBySearchCriteria(bookSearchCriteria);
        log.info("There was found {} books", books.size());
        return convertBooksToDtos(books);
    }

    private List<BookListDto> convertBooksToDtos(List<Book> books) {
        return books
                .stream()
                .map(this::convertBookToDto)
                .collect(toList());
    }

    private BookListDto convertBookToDto(Book book) {
        return modelMapper.map(book, BookListDto.class);
    }

    private List<BookSearchCriteria> convertFromDtosToBookSearchCriteria(List<BookSearchCriteriaDto> bookSearchCriteriaDto) {
        return bookSearchCriteriaDto
                .stream()
                .map(this::convertFromDtoToBookSearchCriteria)
                .collect(toList());
    }

    private BookSearchCriteria convertFromDtoToBookSearchCriteria(BookSearchCriteriaDto bookSearchCriteriaDto) {
        return modelMapper.map(bookSearchCriteriaDto, BookSearchCriteria.class);
    }
}
