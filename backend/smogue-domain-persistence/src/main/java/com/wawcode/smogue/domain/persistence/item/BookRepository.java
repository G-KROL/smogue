package com.wawcode.smogue.domain.persistence.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByIsbn(String bookIsbn);

    List<Book> findAllByAuthor(Author author);
}
