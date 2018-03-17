package com.wawcode.smogue.domain.persistence.item;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "author")
@SequenceGenerator(name = "SEQUENCE_GENERATOR",
        sequenceName = "author_seq",
        allocationSize = 1,
        initialValue = 1000)
public class Author implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQUENCE_GENERATOR", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, insertable = false, nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "created_on", nullable = false, updatable = false)
    private LocalDateTime createdOn;

    @Column(name = "created_by", nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    protected Author() {
    }

    public Author(String firstName, String lastName, String createdBy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdOn = LocalDateTime.now();
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }
}
