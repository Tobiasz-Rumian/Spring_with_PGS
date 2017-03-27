package com.currencyExchange.service.impl;

import com.currencyExchange.model.ExchangeModel;
import com.currencyExchange.service.ExchangeClient;
import com.currencyExchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by piotr on 22.03.17.
 */
@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ExchangeClient exchangeClient;

    @Override
    public ExchangeModel getExchange() {
        return exchangeClient.getExchange();
    }
}
