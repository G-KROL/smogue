package com.wawcode.smogue.domain.persistence.borrow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wawcode.smogue.domain.persistence.borrower.Borrower;
import com.wawcode.smogue.domain.persistence.item.Item;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    Optional<Borrow> findByItem (Item item);

    List<Borrow> findAllByDueDateTime(LocalDateTime dueDateTime);

    List<Borrow> findAllByReturnDateTime(LocalDateTime returnDateTime);

    List<Borrow> findAllByBorrower(Borrower borrower);
}
