package com.wawcode.smogue.domain.persistence.item;

public enum Category {

    CRIMINAL("CRIMINAL"),
    NEWS("NEWS"),
    SCIENCE_FICTION("SCIENCE FICTION"),
    ACTION("ACTION"),
    TRAVEL_GUIDE("TRAVEL GUIDE"),
    HISTORY("HISTORY"),
    MATH("MATH"),
    DICTIONARIES("DICTIONARIES"),
    FANTASY("FANTASY"),
    ART("ART"),
    POETRY("POETRY"),
    ROMANCE("ROMANCE");

    private String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}