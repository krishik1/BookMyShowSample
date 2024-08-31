package com.book.my.show.bookmyshowonline.controller;

import com.book.my.show.bookmyshowonline.dto.ShowSeatRequestDTO;
import com.book.my.show.bookmyshowonline.model.ShowSeat;
import com.book.my.show.bookmyshowonline.service.ShowSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowSeatController {

    @Autowired
    private ShowSeatService showSeatService;

    @GetMapping("/insert/seats")
    private ResponseEntity insertShowSeats(){
        List<ShowSeat> showSeats = showSeatService.insertShowSeats();
        return ResponseEntity.ok(showSeats);
    }
//    @GetMapping("/view/seats/{movieName}/{auditoriumName}")
//    private ResponseEntity viewSeats(ShowSeatRequestDTO showSeatRequestDTO) {
//        String movieName = showSeatRequestDTO.getMovieName();
//        String audiName = showSeatRequestDTO.getAuditoriumName();
//        return ResponseEntity.ok(showSeatService.viewSeats(movieName,audiName));
//    }
    @GetMapping("/view/seats/{movieName}/{auditoriumName}/{offset}/{pagesize}")
    private ResponseEntity viewSeats(ShowSeatRequestDTO showSeatRequestDTO,@PathVariable int offset,@PathVariable int pagesize) {
        String movieName = showSeatRequestDTO.getMovieName();
        String audiName = showSeatRequestDTO.getAuditoriumName();
        return ResponseEntity.ok(showSeatService.viewSeats(movieName,audiName,offset,pagesize));
    }
}
