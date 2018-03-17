package com.wawcode.smogue.domain.persistence.borrow;

import com.wawcode.smogue.domain.persistence.borrower.Borrower;
import com.wawcode.smogue.domain.persistence.item.Item;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "borrow")
@SequenceGenerator(name = "SEQUENCE_GENERATOR",
        sequenceName = "borrow_seq",
        allocationSize = 1,
        initialValue = 1000)
public class Borrow implements Serializable {

    public static final BigDecimal FINE_VALUE_PER_DAY = new BigDecimal("5");

    @Id
    @GeneratedValue(generator = "SEQUENCE_GENERATOR", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", insertable = false, updatable = false, nullable = false)
    private Long id;

    @Column(name = "due_date_time", nullable = false)
    private LocalDateTime dueDateTime;

    @Column(name = "fine")
    private BigDecimal fine;

    @Column(name = "return_date_time")
    private LocalDateTime returnDateTime;

    @Column(name = "created_on", nullable = false, updatable = false)
    private LocalDateTime createdOn;

    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "number_of_borrowed_item_copies" , nullable = false)
    private int numberOfBorrowedItemCopies;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "borrower_id", nullable = false)
    private Borrower borrower;

    protected Borrow() {
    }

    public Borrow(LocalDateTime dueDateTime, String createdBy, int numberOfBorrowedItemCopies, Item item, Borrower borrower) {
        this.dueDateTime = dueDateTime;
        this.createdOn = LocalDateTime.now();
        this.createdBy = createdBy;
        this.numberOfBorrowedItemCopies = numberOfBorrowedItemCopies;
        this.item = item;
        this.borrower = borrower;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public LocalDateTime getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(LocalDateTime returnDateTime){
        this.returnDateTime = returnDateTime;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public int getNumberOfBorrowedItemCopies() {
        return numberOfBorrowedItemCopies;
    }

    public Item getItem() {
        return item;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void fine(BigDecimal numberOfDayAfterDueDate){
        this.fine = FINE_VALUE_PER_DAY.multiply(numberOfDayAfterDueDate);
    }
}
