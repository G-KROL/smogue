package com.wawcode.smogue.application.borrow;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wawcode.smogue.domain.api.borrow.BorrowCreateDto;
import com.wawcode.smogue.domain.api.borrow.BorrowCreateService;
import com.wawcode.smogue.domain.api.borrower.BorrowerChosenToBorrowDto;
import com.wawcode.smogue.domain.api.item.BookDetailDto;
import com.wawcode.smogue.domain.api.item.BookDetailService;

@RestController
@RequestMapping("/api")
public class BorrowController {

    private BorrowCreateService borrowCreateService;
    private BookDetailService bookDetailService;

    @Autowired
    public BorrowController(BorrowCreateService borrowCreateService, BookDetailService bookDetailService) {
        this.borrowCreateService = borrowCreateService;
        this.bookDetailService = bookDetailService;
    }

    @RequestMapping(value = "/books/{bookIsbn}/borrow", method = RequestMethod.POST)
    public @ResponseBody
    BorrowCreateDto getBookDetails(@PathVariable("bookIsbn") String bookIsbn,
                                   @RequestBody BorrowerChosenToBorrowDto borrowerChosenToBorrowDto) {
        BookDetailDto bookDetails = bookDetailService.getBookDetails(bookIsbn);
        return borrowCreateService.createBorrow(bookDetails, borrowerChosenToBorrowDto);
    }
}
