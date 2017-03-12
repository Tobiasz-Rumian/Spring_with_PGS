package com.currencyExchange.dto;

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
