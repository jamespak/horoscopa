package com.example.horoscopa.services;

import com.example.horoscopa.entities.HoroscopeEntity;
import com.example.horoscopa.repository.HoroscopeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HoroscopeService {

    private final HoroscopeRepository repo;

    public HoroscopeService(HoroscopeRepository repo) {
        this.repo = repo;
    }

    public Optional<HoroscopeEntity> getHoroscope(Long Id)
    {
        return repo.findById(Id);

    }

}
