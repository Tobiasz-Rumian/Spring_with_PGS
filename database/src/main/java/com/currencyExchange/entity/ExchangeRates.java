package com.currencyExchange.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name="exchangerates")
public class ExchangeRates {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    Date time;

    @Column
    String currencyFrom;

    @Column
    String currencyTo;

    @Column
    BigDecimal exchangeRate;


}