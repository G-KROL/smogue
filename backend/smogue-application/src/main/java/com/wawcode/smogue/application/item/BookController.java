package com.wawcode.smogue.application.item;

import com.wawcode.smogue.domain.api.item.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookSearchService bookSearchService;
    private final BookDetailService bookDetailService;
    private final BookCreateService bookCreateService;
    private final BookDeleteService bookDeleteService;
    private final BookEditService bookEditService;

    @Autowired
    public BookController(BookSearchService bookSearchService, BookDetailService bookDetailService, BookCreateService bookCreateService, BookDeleteService bookDeleteService, BookEditService bookEditService) {
        this.bookSearchService = bookSearchService;
        this.bookDetailService = bookDetailService;
        this.bookCreateService = bookCreateService;
        this.bookDeleteService = bookDeleteService;
        this.bookEditService = bookEditService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public @ResponseBody
    List<BookListDto> findAllBooks(@RequestParam(value = "search", required = false) String search) {
        List<BookSearchCriteriaDto> params = getBookSearchCriteriaParams(search);
        return bookSearchService.searchBooksBySearchCriteria(params);
    }

    @RequestMapping(value = "/books/{bookIsbn}", method = RequestMethod.GET)
    public @ResponseBody
    BookDetailDto getBookDetails(@PathVariable("bookIsbn") String bookIsbn) {
        return bookDetailService.getBookDetails(bookIsbn);
    }

    @RequestMapping(value = "/books/{bookIsbn}", method = RequestMethod.POST)
    public @ResponseBody
    BookCreateDto createBook(@PathVariable("bookIsbn") String bookIsbn,
                             @RequestBody BookCreateDto bookCreateDto) {
        return bookCreateService.createBook(bookIsbn, bookCreateDto);
    }

    @RequestMapping(value = "books/{bookIsbn}", method = RequestMethod.DELETE)
    public @ResponseBody
    String deleteBook(@PathVariable(value = "bookIsbn") String bookIsbn) {
        return bookDeleteService.deleteBook(bookIsbn);
    }

    @RequestMapping(value = "books/{bookIsbn}", method = RequestMethod.PUT)
    BookEditDto editBook(@PathVariable(value = "bookIsbn") String bookIsbn,
                         @RequestBody BookEditDto bookEditDto) {
        return bookEditService.edit(bookIsbn, bookEditDto);
    }

    private List<BookSearchCriteriaDto> getBookSearchCriteriaParams(@RequestParam(value = "search", required = false) String search) {
        List<BookSearchCriteriaDto> params = new ArrayList<>();
        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?)([:<>])(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                params.add(new BookSearchCriteriaDto(matcher.group(1), matcher.group(2), matcher.group(3)));
            }
        }
        return params;
    }
}
