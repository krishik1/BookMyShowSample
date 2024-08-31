package com.book.my.show.bookmyshowonline.service;

import com.book.my.show.bookmyshowonline.model.City;
import com.book.my.show.bookmyshowonline.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City addCity(String cityName) {
        City city = new City();
        city.setName(cityName);
        cityRepository.save(city);
        return  city;
    }
    public boolean removeCityById(int id){
        cityRepository.deleteById(id);
        return true;
    }
    public City getCity(String cityName) {
        City city = cityRepository.findByName(cityName);
        return city;
    }

    public City saveCity(City city) {
        City currCity = cityRepository.save(city);
        return currCity;
    }
}
