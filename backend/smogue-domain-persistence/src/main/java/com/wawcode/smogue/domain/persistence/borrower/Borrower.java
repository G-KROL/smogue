package com.wawcode.smogue.domain.persistence.borrower;

import org.hibernate.validator.constraints.Email;
import com.wawcode.smogue.domain.persistence.borrow.Borrow;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "borrower")
@SequenceGenerator(name = "SEQUENCE_GENERATOR",
        sequenceName = "borrower_seq",
        allocationSize = 1,
        initialValue = 1000)
public class Borrower implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQUENCE_GENERATOR", strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, insertable = false, nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "amount_of_fines")
    private BigDecimal amountOfFines;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @OneToMany(mappedBy = "borrower")
    private Set<Borrow> borrows = new HashSet<>();

    protected Borrower() {
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

    public BigDecimal getAmountOfFines() {
        return amountOfFines;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Set<Borrow> getBorrows() {
        return borrows;
    }

    public void addBorrowToBorrower(Borrow borrow) {
        this.borrows.add(borrow);
    }

    public void removeBorrowFromBorrower(Borrow borrow) {
        this.borrows.remove(borrow);
    }

    public void updatedAmountOfFines(BigDecimal newFine) {
        if (this.amountOfFines == null) {
            this.amountOfFines = newFine;
        } else {
            this.amountOfFines.add(new BigDecimal(String.valueOf(newFine)));
        }
    }
}
