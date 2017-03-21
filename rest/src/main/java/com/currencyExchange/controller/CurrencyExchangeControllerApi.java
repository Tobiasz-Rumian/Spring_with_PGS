package com.currencyExchange.controller;

import com.currencyExchange.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by zekori on 14.03.17.
 */
@RestController
@RequestMapping("/api")
public class CurrencyExchangeControllerApi {

    @Autowired
    private Collection<CurrencyExchangeService> exchangeServices;
    @Autowired
    private String bean;

    @RequestMapping("/list")
    public List<String> allExchanges(){
     List<String> results = new ArrayList<>();
     exchangeServices.forEach((currencyExchangeService -> results.add(currencyExchangeService.getCurrency())));
     results.add(bean);
     return results;
    }

    @RequestMapping("/list/status")
    public ResponseEntity<List<String>> allResponseExchanges(){
        List<String> results = new ArrayList<>();
        exchangeServices.forEach((currencyExchangeService -> results.add(currencyExchangeService.getCurrency())));
        return new ResponseEntity<List<String>>(results, HttpStatus.CREATED);
    }

    @RequestMapping("/list/decorator")
    public List<String> allResponseExchangesDecorator(HttpServletRequest request, HttpServletResponse response){
        List<String> results = new ArrayList<>();
        exchangeServices.forEach((currencyExchangeService -> results.add(currencyExchangeService.getCurrency())));
        response.setStatus(401);
        return results;
    }

}


/*
Napisać serwis do wymiany walut. Kontroler 3 endpointy każdy używa innego podejścia (autowired, response entity, autowired z Response)
 */