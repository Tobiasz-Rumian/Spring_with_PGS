package com.currencyExchange.controller;

import com.currencyExchange.model.CurrencyParams;
import com.currencyExchange.service.OpenCurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zekori on 16.03.17.
 */
@RestController
@RequestMapping("/api")
public class NewController {

    @Autowired
    OpenCurrencyExchangeService client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello(@RequestParam(name = "n", defaultValue = "noName") String name){
        return "hello "+name;
    }

    @RequestMapping(value = "/currency",method = RequestMethod.GET)
    CurrencyParams getCurrency(@Validated CurrencyParams params){
        return params;
    }

    @RequestMapping(value = "/status",method = RequestMethod.POST)
    ResponseEntity<CurrencyParams>getCurrencyParams(@RequestBody CurrencyParams params){

        return new ResponseEntity<CurrencyParams>(params,HttpStatus.I_AM_A_TEAPOT);
    }
    @RequestMapping("/exchange")
    String getExchange(){
        return client.getExchange();
    }

}
