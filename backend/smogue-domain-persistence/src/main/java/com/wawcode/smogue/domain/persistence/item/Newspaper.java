package com.wawcode.smogue.domain.persistence.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "newspaper")
public class Newspaper extends Item {

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "country_of_publishing")
    private String countryOfPublishing;

    public String getType() {
        return type;
    }

    public String getCountryOfPublishing() {
        return countryOfPublishing;
    }
}
