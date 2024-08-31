package com.book.my.show.bookmyshowonline.controller;

import com.book.my.show.bookmyshowonline.service.StartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {
    @Autowired
    StartService startService;

    @GetMapping("/start")
    public ResponseEntity greet(){
        String name = startService.greet();
        return ResponseEntity.ok(name);
    }
}
