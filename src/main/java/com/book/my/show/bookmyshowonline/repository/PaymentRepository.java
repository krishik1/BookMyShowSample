package com.book.my.show.bookmyshowonline.repository;

import com.book.my.show.bookmyshowonline.model.Actor;
import com.book.my.show.bookmyshowonline.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
