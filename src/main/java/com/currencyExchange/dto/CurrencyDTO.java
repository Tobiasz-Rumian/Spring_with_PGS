package com.currencyExchange.dto;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by zekori on 09.03.17.
 */
@lombok.Getter
@lombok.Setter
@lombok.Builder
public class CurrencyDTO {
    private BigDecimal value;
    private Currency currency;


}
