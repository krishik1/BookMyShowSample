package com.book.my.show.bookmyshowonline.service;

import com.book.my.show.bookmyshowonline.model.User;
import com.book.my.show.bookmyshowonline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitService {
    @Autowired
    private UserRepository userRepository;

    public List<User> addUser(){
        List<User> users = new ArrayList<>();
        User jaga = new User("Jagadeesh","jagadeesh.pj@gmail.com","Jaggu@1497");
        User adhi = new User("Adhitya","adhitya12@gmail.com","Adhi@2299");
        User chid = new User("Chidvi","chid01@gmail.com","chid@0197");
        User santosh = new User("Santosh","satosh.somayajula@gmail.com","Santhu@0698");
        User kalli = new User("Kalyan","kalyan.cap@gmail.com","Kalyan@0898");
        User prasad = new User("Prasad","prasad.boye@gmail.com","Prasad@0596");
        User avi = new User("Avinash","avinash.royal@gmail.com","Avi@1297");
        users.add(jaga);
        users.add(adhi);
        users.add(chid);
        users.add(santosh);
        users.add(kalli);
        users.add(prasad);
        users.add(avi);
        List<User> savedUsers = userRepository.saveAll(users);
        return savedUsers;
    }
}
