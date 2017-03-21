package com.currencyExchange.service.impl;

import com.currencyExchange.service.CurrencyExchangeService;
import org.springframework.stereotype.Service;

/**
 * Created by zekori on 14.03.17.
 */
@Service("ugly")
public class UglyCurrencyExchangeServiceImpl implements CurrencyExchangeService {
    @Override
    public String getCurrency() {
        return "Ugly money";
    }
}
