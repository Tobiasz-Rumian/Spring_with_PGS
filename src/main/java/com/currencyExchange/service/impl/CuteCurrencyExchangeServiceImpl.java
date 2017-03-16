package com.currencyExchange.service.impl;

import com.currencyExchange.condition.LinuxCondition;
import com.currencyExchange.service.CurrencyExchangeService;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
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
