package com.example.horoscopa.repository;

import com.example.horoscopa.entities.HoroscopeEntity;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.repository.CrudRepository;

public interface HoroscopeRepository extends CrudRepository<HoroscopeEntity, Long> {


}
