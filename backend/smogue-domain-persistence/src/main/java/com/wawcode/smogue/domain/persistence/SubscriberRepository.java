package com.wawcode.smogue.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
    Subscriber findByEmail (String email);
}
