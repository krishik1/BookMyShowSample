package com.book.my.show.bookmyshowonline.service;

import com.book.my.show.bookmyshowonline.model.City;
import com.book.my.show.bookmyshowonline.model.Theatre;
import com.book.my.show.bookmyshowonline.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private CityService cityService;

    public Theatre saveTheatre(String name,String address,String cityName) {
        Theatre theatre = new Theatre();
        theatre.setName(name);
        theatre.setAddress(address);
        Theatre savedTheatre = theatreRepository.save(theatre);
        City city = cityService.getCity(cityName);
        if (city == null) {
            throw new IllegalArgumentException("City cannot be null");
        }

        List<Theatre> theatres = new ArrayList<>();

        if (city.getTheatres() != null) {
            theatres = city.getTheatres();
        }
        theatres.add(savedTheatre);
        city.setTheatres(theatres);
        cityService.saveCity(city);
        return savedTheatre;
    }
}
