package com.wawcode.smogue.domain.persistence.repositories;

import com.wawcode.smogue.domain.persistence.entities.CityRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CityRepository extends JpaRepository<CityRegion, Long> {
    Set<CityRegion> findByName(String name);

    Optional<CityRegion> findByCode(Integer code);
}
