package com.wawcode.smogue.domain.persistence.item;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "book")
public class Book extends Item {

    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "number_of_pages", nullable = false)
    private Integer numberOfPages;

    @Column(name = "edition")
    private String edition;

    @ManyToOne(fetch = LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    protected Book() {
    }

    public Book(String title, int numberOfCopies, String category, String createdBy, LocalDateTime publishingDate, String isbn, Integer numberOfPages, String edition, Author author) {
        super(title, numberOfCopies, Category.valueOf(category), createdBy, publishingDate);
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.edition = edition;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public String getEdition() {
        return edition;
    }

    public Author getAuthor() {
        return author;
    }

    public void edit(String title, int numberOfCopies, String category, String updatedBy, String publisher, LocalDateTime publishingDate,
                     Integer numberOfPages, String edition) {

        super.edit(title, numberOfCopies, category, updatedBy, publisher, publishingDate);
        this.numberOfPages = numberOfPages;
        this.edition = edition;
    }
}
