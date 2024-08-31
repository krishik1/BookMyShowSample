package com.book.my.show.bookmyshowonline.controller;

import com.book.my.show.bookmyshowonline.dto.UserLogInRequestDTO;
import com.book.my.show.bookmyshowonline.dto.UserSignUpRequestDTO;
import com.book.my.show.bookmyshowonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserSignUpRequestDTO userSignUpRequestDTO) throws Exception {
        return ResponseEntity.ok(userService.signup(userSignUpRequestDTO.getName(),
                userSignUpRequestDTO.getEmail(),userSignUpRequestDTO.getPassword()));
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLogInRequestDTO userLogInRequestDTO) throws Exception {
        return ResponseEntity.ok(
                userService.login(userLogInRequestDTO.getEmail(),userLogInRequestDTO.getPassword()));
    }
}
