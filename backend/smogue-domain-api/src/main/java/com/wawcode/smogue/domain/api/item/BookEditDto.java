package com.wawcode.smogue.domain.api.item;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class BookEditDto {

    private String title;
    private String category;
    private Integer numberOfPages;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishingDate;

    private String publisher;
    private String edition;
    private int numberOfCopies;

    public BookEditDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public LocalDateTime getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDateTime publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
}
