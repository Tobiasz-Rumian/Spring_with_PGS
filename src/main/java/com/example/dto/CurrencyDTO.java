package com.example.dto;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.math.BigDecimal;

/**
 * Created by zekori on 09.03.17.
 */
@lombok.Getter
@lombok.Setter
public class CurrencyDTO {
    private BigDecimal value;
    private String currency;


}
