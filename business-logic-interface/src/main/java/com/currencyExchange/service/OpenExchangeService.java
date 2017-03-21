package com.currencyExchange.service;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

/**
 * Created by Tobiasz Rumian on 21.03.2017.
 */
public interface OpenExchangeService {
    String getExchange(Currency currency1, Currency currency2);

    String getExchange(List<Currency> currencies1);

    String getExchange(BigDecimal value, Currency currency1, Currency currency2);

    String getExchange(String date,BigDecimal value, Currency currency1, Currency currency2);
}
