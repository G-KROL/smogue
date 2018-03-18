package com.wawcode.smogue.domain.api;

public class SubscriberDto {

    private String name;
    private int number;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SubscriberDto{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", email='" + email + '\'' +
                '}';
    }
}
