package com.book.my.show.bookmyshowonline.repository;

import com.book.my.show.bookmyshowonline.model.Actor;
import com.book.my.show.bookmyshowonline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findUserByEmailId(String emailId);
}
