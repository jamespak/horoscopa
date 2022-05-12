package com.example.horoscopa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class HoroscopeEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String horoscope;
    private String sign;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
