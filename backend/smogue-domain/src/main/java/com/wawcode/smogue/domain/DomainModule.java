package com.wawcode.smogue.domain;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainModule {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
