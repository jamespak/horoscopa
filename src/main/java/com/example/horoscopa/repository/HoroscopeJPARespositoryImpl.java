package com.example.horoscopa.repository;

import com.example.horoscopa.entities.HoroscopeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Primary
@Repository
public class HoroscopeJPARespositoryImpl implements HoroscopeRepository{

    @Autowired
    private HoroscopeRepository repo;

    @Override
    public <S extends HoroscopeEntity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends HoroscopeEntity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<HoroscopeEntity> findById(Long id)
    {
        return repo.findById(id);
    }

    @Override
    public boolean existsById(Long id)
    {
        return repo.existsById(id);
    }

    @Override
    public Iterable<HoroscopeEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<HoroscopeEntity> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(HoroscopeEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends HoroscopeEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
