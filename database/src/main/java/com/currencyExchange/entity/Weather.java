package com.currencyExchange.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="weather")
public class Weather {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String city;

    @Column
    private Double temp;

    @Column
    private Double pressure;

    @Column
    private Timestamp time;

}
