package com.book.my.show.bookmyshowonline.controller;

import com.book.my.show.bookmyshowonline.dto.CityRequestDTO;
import com.book.my.show.bookmyshowonline.model.City;
import com.book.my.show.bookmyshowonline.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;
    @GetMapping("/city/{city}")
    public ResponseEntity getCity(@PathVariable("city") String city){
        City cityName = cityService.getCity(city);
        return ResponseEntity.ok(cityName);
    }
    @PostMapping("/city")
    public ResponseEntity saveCity(@RequestBody CityRequestDTO requestDTO) {
        String city=requestDTO.getCityName();
        try{
            if(city == null || city.isBlank() || city.isEmpty()) {
                throw new Exception("City Name Is Invalid");
            }
            City saveCity = cityService.addCity(city);
            return ResponseEntity.ok(saveCity);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("city/{id}")
    public ResponseEntity deleteCity(@PathVariable("id") int id) {
        boolean isDeleted = cityService.removeCityById(id);
        return ResponseEntity.ok(isDeleted);
    }

}
