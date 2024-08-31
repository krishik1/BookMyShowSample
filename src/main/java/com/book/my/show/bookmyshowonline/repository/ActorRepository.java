package com.book.my.show.bookmyshowonline.repository;

import com.book.my.show.bookmyshowonline.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor,Integer> {
}
