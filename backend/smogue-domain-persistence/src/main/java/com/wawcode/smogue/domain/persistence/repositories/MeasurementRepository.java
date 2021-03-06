package com.wawcode.smogue.domain.persistence.repositories;

import com.wawcode.smogue.domain.persistence.entities.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    Optional<Measurement> findByStationIdAndTimestampAndTypeId(Long id, Long timestamp, Long typeId);

    Set<Measurement> findByStationIdAndTimestampAfter(Long id, Long timestamp);

    Set<Measurement> findByTimestampAfter(Long timestamp);
}
