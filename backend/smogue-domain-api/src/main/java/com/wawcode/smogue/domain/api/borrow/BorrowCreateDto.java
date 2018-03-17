package com.wawcode.smogue.domain.api.borrow;

import com.wawcode.smogue.domain.api.item.ItemCreateBorrowDto;
import com.wawcode.smogue.domain.api.borrower.BorrowerChosenToBorrowDto;

import java.time.LocalDateTime;

public class BorrowCreateDto {

    private LocalDateTime dueDateTime;
    private String createdBy;
    private int numberOfBorrowedItemCopies;
    private ItemCreateBorrowDto item;
    private BorrowerChosenToBorrowDto borrower;

    protected BorrowCreateDto() {
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getNumberOfBorrowedItemCopies() {
        return numberOfBorrowedItemCopies;
    }

    public void setNumberOfBorrowedItemCopies(int numberOfBorrowedItemCopies) {
        this.numberOfBorrowedItemCopies = numberOfBorrowedItemCopies;
    }

    public ItemCreateBorrowDto getItem() {
        return item;
    }

    public void setItem(ItemCreateBorrowDto item) {
        this.item = item;
    }

    public BorrowerChosenToBorrowDto getBorrower() {
        return borrower;
    }

    public void setBorrower(BorrowerChosenToBorrowDto borrower) {
        this.borrower = borrower;
    }
}
