package com.currencyExchange.service.impl;

import com.currencyExchange.service.CurrencyExchangeService;
import org.springframework.stereotype.Service;

/**
 * Created by zekori on 14.03.17.
 */
@Service("cute")
public class CuteCurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Override
    public String getCurrency() {
        return "Cute money";
    }
}
