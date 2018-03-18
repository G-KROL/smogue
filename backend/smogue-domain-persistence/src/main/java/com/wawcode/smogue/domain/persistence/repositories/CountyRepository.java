package com.wawcode.smogue.domain.persistence.repositories;

import com.wawcode.smogue.domain.persistence.entities.CountyRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CountyRepository extends JpaRepository<CountyRegion, Long> {
    Set<CountyRegion> findByName(String name);

    Optional<CountyRegion> findByCode(Integer code);
}
