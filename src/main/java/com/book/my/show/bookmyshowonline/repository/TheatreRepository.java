package com.book.my.show.bookmyshowonline.repository;

import com.book.my.show.bookmyshowonline.model.Actor;
import com.book.my.show.bookmyshowonline.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre,Integer> {
}
