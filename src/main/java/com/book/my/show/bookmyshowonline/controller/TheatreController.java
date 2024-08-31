package com.book.my.show.bookmyshowonline.controller;

import com.book.my.show.bookmyshowonline.dto.TheatreRequestDTO;
import com.book.my.show.bookmyshowonline.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping("/theatre")
    public ResponseEntity saveTheatre(@RequestBody TheatreRequestDTO theatreRequestDTO) {
        return ResponseEntity.ok(theatreService.saveTheatre(theatreRequestDTO.getName(),
                theatreRequestDTO.getAddress(),theatreRequestDTO.getCityName()));
    }
}
