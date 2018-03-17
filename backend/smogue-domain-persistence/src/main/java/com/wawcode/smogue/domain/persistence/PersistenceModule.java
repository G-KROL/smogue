package com.wawcode.smogue.domain.persistence;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@PropertySource({"classpath:application-persistence.properties"})
@ComponentScan({"com.wawcode.smogue.domain.persistence"})
@EnableJpaRepositories("com.wawcode.smogue.domain.persistence")
@EntityScan(basePackages = {"com.wawcode.smogue.domain.persistence"}, basePackageClasses = {Jsr310JpaConverters.class})
@Configuration
public class PersistenceModule {

}
