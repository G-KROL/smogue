package com.wawcode.smogue.domain.persistence.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByTitle(String title);

    List<Item> findAllByCategory(Category category);
}
