package com.currencyExchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by zekori on 16.03.17.
 */
@Service
public class OpenCurrencyExchangeService {

    String url="http://api.fixer.io/latest?symbols=USD,GBP&base=PLN";


    @Autowired
    RestTemplate rest;

    public String getExchange(){
        Map<String,Object> response= rest.getForObject(url, HashMap.class);
        return response.toString();
    }
}
