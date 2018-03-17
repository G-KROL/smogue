package com.wawcode.smogue.domain.api.borrow;

import com.wawcode.smogue.domain.api.item.BookDetailDto;
import com.wawcode.smogue.domain.api.borrower.BorrowerChosenToBorrowDto;

public interface BorrowCreateService {

    BorrowCreateDto createBorrow(BookDetailDto bookDetailDto, BorrowerChosenToBorrowDto borrowerChosenToBorrowDto);
}
