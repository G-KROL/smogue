package com.wawcode.smogue.domain.persistence.repositories;

import com.wawcode.smogue.domain.persistence.entities.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
}
