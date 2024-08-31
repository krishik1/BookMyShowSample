package com.book.my.show.bookmyshowonline.service;

import com.book.my.show.bookmyshowonline.model.Auditorium;
import com.book.my.show.bookmyshowonline.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditoriumService {
    @Autowired
    private AuditoriumRepository auditoriumRepository;

    public Auditorium saveAuditorium(Auditorium auditorium){
        return auditoriumRepository.save(auditorium);
    }
    public Auditorium getAuditorium(String auditoriumName){
        System.out.println(auditoriumName);
        return auditoriumRepository.findAuditoriumByAudiToriumName(auditoriumName);
    }
}
