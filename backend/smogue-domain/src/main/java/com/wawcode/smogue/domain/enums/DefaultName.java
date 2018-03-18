package com.wawcode.smogue.domain.enums;

public enum DefaultName {
    UNDEFINED_NAME("UNDEFINED");
    
    private String name;

    DefaultName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
