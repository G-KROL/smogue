package com.wawcode.smogue.domain.api.item;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ItemCreateBorrowDto {

    private String title;
    private int numberOfCopies;
    private String category;
    private String publisher;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishingDate;

    protected ItemCreateBorrowDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDateTime getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDateTime publishingDate) {
        this.publishingDate = publishingDate;
    }
}
