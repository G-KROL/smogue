package com.wawcode.smogue.domain.persistence.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewspaperRepository extends JpaRepository<Newspaper, Long> {

    List<Newspaper> findAllByType(String type);

    List<Newspaper> findAllByCountryOfPublishing(String countryOfPublishing);
}
