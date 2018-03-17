package com.wawcode.smogue.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan({"com.wawcode.smogue"})
@PropertySource("classpath:application.properties")
@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(LibraryApplication.class)
                .run(args);
    }
}
