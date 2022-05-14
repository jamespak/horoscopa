package com.example.horoscopa.controllers;

import com.example.horoscopa.entities.HoroscopeEntity;
import com.example.horoscopa.services.HoroscopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class HoroscopeController {

    public HoroscopeController(HoroscopeService horoscopeService) {
        this.horoscopeService = horoscopeService;
    }

    @Autowired
    private HoroscopeService horoscopeService;

    @GetMapping("/horoscope/{id}")
    public Optional<HoroscopeEntity> getHoroscope(@PathVariable Long id)
    {
        return horoscopeService.getHoroscope(id);
    }

    @GetMapping("/horoscope/exists/{id}")
    public Boolean existHoroscope(@PathVariable Long id)
    {
        return horoscopeService.exists(id);
    }

    @PostMapping("/horoscope")
    public HoroscopeEntity SaveHoroscope(@RequestBody HoroscopeEntity horoscope){

        return horoscopeService.save(horoscope);
    }


}
