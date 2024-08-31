package com.book.my.show.bookmyshowonline.service;

import com.book.my.show.bookmyshowonline.model.Seat;
import com.book.my.show.bookmyshowonline.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }
}
