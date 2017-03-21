package com.currencyExchange.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by zekori on 16.03.17.
 */
@Data
public class CurrencyParams {

    @Valid
    @Size(min = 2,max = 50)
    private String  currency;

    private Integer value;
    private Integer exchange;
}
