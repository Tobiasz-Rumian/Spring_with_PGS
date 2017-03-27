package com.currencyExchange.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="currency")
public class Currency {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    String currencyCode;

    @Column
    String name;
}
