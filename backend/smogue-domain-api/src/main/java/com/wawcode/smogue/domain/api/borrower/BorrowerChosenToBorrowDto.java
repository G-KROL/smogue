package com.wawcode.smogue.domain.api.borrower;

public class BorrowerChosenToBorrowDto {

    private String firstName;
    private String lastName;
    private String email;

    protected BorrowerChosenToBorrowDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
