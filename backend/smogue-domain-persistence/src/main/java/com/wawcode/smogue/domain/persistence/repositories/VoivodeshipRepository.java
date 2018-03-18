package com.wawcode.smogue.domain.persistence.repositories;

import com.wawcode.smogue.domain.persistence.entities.VoivodeshipRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface VoivodeshipRepository extends JpaRepository<VoivodeshipRegion, Long> {

    Set<VoivodeshipRegion> findByName(String name);

    Optional<VoivodeshipRegion> findByCode(Integer code);
}
