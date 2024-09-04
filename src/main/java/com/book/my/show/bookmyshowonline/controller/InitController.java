package com.book.my.show.bookmyshowonline.controller;

import com.book.my.show.bookmyshowonline.service.InitService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {
    @Autowired
    private InitService initService;
    @GetMapping("/retieveUses")
    public ResponseEntity addUsers() {
        return ResponseEntity.ok(initService.addUser());
    }
}
