package com.wawcode.smogue.domain.persistence.item;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@SequenceGenerator(name = "SEQUENCE_GENERATOR",
        sequenceName = "item_seq",
        allocationSize = 1,
        initialValue = 1000)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Item implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQUENCE_GENERATOR", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, insertable = false, nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "number_of_copies", nullable = false)
    private int numberOfCopies;

    @Column(name = "category", nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "created_on", nullable = false, updatable = false)
    private LocalDateTime createdOn;

    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "publishing_date", nullable = false)
    private LocalDateTime publishingDate;

    protected Item() {
    }

    protected Item(String title, int numberOfCopies, Category category, String createdBy, LocalDateTime publishingDate) {
        this.title = title;
        this.numberOfCopies = numberOfCopies;
        this.category = category;
        this.createdOn = LocalDateTime.now();
        this.createdBy = createdBy;
        this.publishingDate = publishingDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public String getPublisher() {
        return publisher;
    }

    public LocalDateTime getPublishingDate() {
        return publishingDate;
    }

    public boolean isAvailable() {
        return this.numberOfCopies > 0;
    }

    public void borrowCopiesOfItem(int numberOfBorrowedCopies) {
        this.numberOfCopies -= numberOfBorrowedCopies;
    }

    public void returnCopiesOfItem(int numberOfBorrowedCopies) {
        this.numberOfCopies += numberOfBorrowedCopies;
    }

    public void edit(String title, int numberOfCopies, String category, String updatedBy, String publisher, LocalDateTime publishingDate) {
        this.title = title;
        this.numberOfCopies = numberOfCopies;
        this.category = Category.valueOf(category);
        this.updatedOn = LocalDateTime.now();
        this.updatedBy = updatedBy;
        this.publisher = publisher;
        this.publishingDate = publishingDate;
    }
}
