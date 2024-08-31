package com.book.my.show.bookmyshowonline.repository;

import com.book.my.show.bookmyshowonline.model.Actor;
import com.book.my.show.bookmyshowonline.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
