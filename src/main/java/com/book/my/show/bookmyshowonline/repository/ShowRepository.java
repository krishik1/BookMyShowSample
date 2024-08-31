package com.book.my.show.bookmyshowonline.repository;

import com.book.my.show.bookmyshowonline.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show,Integer> {
    Show findShowByMovieAndAuditorium(Movie movie, Auditorium auditorium);
    Show findShowByMovie_MovieNameAndAndAuditorium_AudiToriumName(String movieName,String auditoriumName);
}
