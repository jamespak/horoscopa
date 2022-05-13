package com.example.horoscopa.services;

import com.example.horoscopa.entities.HoroscopeEntity;
import com.example.horoscopa.repository.HoroscopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HoroscopeService {

    @Autowired
    private final HoroscopeRepository repo;

    public HoroscopeService(HoroscopeRepository repo) {
        this.repo = repo;
    }

    public Optional<HoroscopeEntity> getHoroscope(Long Id)
    {
        Optional<HoroscopeEntity> response = repo.findById(Id);
        //return repo.findById(Id);
        return response;

    }

    public Boolean exists(Long Id)
    {
        Boolean exist = repo.existsById(Id);
        //return repo.findById(Id);
        return exist;

    }

}
