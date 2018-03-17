package com.wawcode.smogue.domain.persistence.borrower;

import com.wawcode.smogue.domain.persistence.borrow.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

    Optional<Borrower> findByEmail(String email);

    Optional<Borrower> findOneByBorrows(Borrow borrow);

    List<Borrower> findAllByFirstName(String firstName);

    List<Borrower> findAllByLastName(String lastName);

}
