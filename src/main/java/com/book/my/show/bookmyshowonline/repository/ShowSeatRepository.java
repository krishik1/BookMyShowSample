package com.book.my.show.bookmyshowonline.repository;

import com.book.my.show.bookmyshowonline.model.Actor;
import com.book.my.show.bookmyshowonline.model.Show;
import com.book.my.show.bookmyshowonline.model.ShowSeat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {
     List<ShowSeat> findShowSeatsByShow(Show show);
     Page<ShowSeat> findShowSeatsByShow(Show show,Pageable pageable);
}
