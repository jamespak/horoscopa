package com.example.horoscopa.services;

import com.example.horoscopa.entities.HoroscopeEntity;
import com.example.horoscopa.repository.HoroscopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
        return repo.findById(Id);

    }

    public Boolean exists(Long Id)
    {
        return repo.existsById(Id);
    }

    public HoroscopeEntity save(HoroscopeEntity horoscope)
    {
        return repo.save(horoscope);
    }

}
