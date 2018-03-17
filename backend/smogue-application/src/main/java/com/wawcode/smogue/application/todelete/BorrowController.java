//package com.wawcode.smogue.application.todelete;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import pl.altkom.asc.library.domain.api.borrow.BorrowCreateDto;
//import pl.altkom.asc.library.domain.api.borrow.BorrowCreateService;
//import pl.altkom.asc.library.domain.api.borrower.BorrowerChosenToBorrowDto;
//import pl.altkom.asc.library.domain.api.item.BookDetailDto;
//import pl.altkom.asc.library.domain.api.item.BookDetailService;
//
//@RestController
//@RequestMapping("/api")
//public class BorrowController {
//
//    private BorrowCreateService borrowCreateService;
//    private BookDetailService bookDetailService;
//
//    @Autowired
//    public BorrowController(BorrowCreateService borrowCreateService, BookDetailService bookDetailService) {
//        this.borrowCreateService = borrowCreateService;
//        this.bookDetailService = bookDetailService;
//    }
//
//    @RequestMapping(value = "/books/{bookIsbn}/borrow", method = RequestMethod.POST)
//    public @ResponseBody
//    BorrowCreateDto getBookDetails(@PathVariable("bookIsbn") String bookIsbn,
//                                   @RequestBody BorrowerChosenToBorrowDto borrowerChosenToBorrowDto) {
//        BookDetailDto bookDetails = bookDetailService.getBookDetails(bookIsbn);
//        return borrowCreateService.createBorrow(bookDetails, borrowerChosenToBorrowDto);
//    }
//}
