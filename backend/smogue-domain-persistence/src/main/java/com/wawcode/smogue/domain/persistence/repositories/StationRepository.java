package com.wawcode.smogue.domain.persistence.repositories;

import com.wawcode.smogue.domain.persistence.entities.Station;
import com.wawcode.smogue.domain.persistence.entities.StationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    List<Station> findByType(StationType type);
    Optional<Station> findByTypeAndProviderCode(StationType type, String providerCode);
}
