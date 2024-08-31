package com.book.my.show.bookmyshowonline.service;

import com.book.my.show.bookmyshowonline.model.User;
import com.book.my.show.bookmyshowonline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User retirveUser(User user) {
        Optional<User> currUser = userRepository.findUserByEmailId(user.getEmailId());
        if(currUser.isEmpty()) {
            return userRepository.save(user);
        }
        return currUser.get();
    }

    public User login(String email,String password) throws Exception {
        Optional<User> savedUser = userRepository.findUserByEmailId(email);
        if(!savedUser.isPresent()){
            throw new Exception("User with email does not exist");
        }
        User user = savedUser.get();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(password, user.getPassword())) {
            return savedUser.get();
        }
        throw  new Exception("Invalid Password");
    }
    public User signup(String name,String email,String password) throws Exception {
        Optional<User> savedUser = userRepository.findUserByEmailId(email);
        if(savedUser.isPresent()) {
            throw new Exception("User Already Exists.");
        }
        User user = new User();
        user.setUserName(name);
        user.setEmailId(email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        user.setTickets(new ArrayList<>());
        return userRepository.save(user);
    }
    public String maskedPassword(String input) {
        String maskedPart = input.replaceAll(".","*");
        return maskedPart;
    }
}
