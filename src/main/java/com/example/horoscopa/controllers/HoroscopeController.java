package com.example.horoscopa.controllers;

import com.example.horoscopa.services.HoroscopeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class HoroscopeController {

    private HoroscopeService horoscopeService;

    @GetMapping("/horoscope/{id}")
    public String getHoroscope() {
        return horoscopeService.getHoroscope();
    }



}
