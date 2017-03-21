package com.currencyExchange.controller;

import com.currencyExchange.service.OpenExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Tobiasz Rumian on 21.03.2017.
 */
@Controller
@RequestMapping("/exchange")
public class CurrencyExchangeController {

    @Autowired
    Collection<OpenExchangeService> exchangeServices;

    @RequestMapping(value = "/rate",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<String>> GETrate(@RequestParam(name = "c1") String currency1, @RequestParam(name = "c2") String currency2){
        List<String> results = new ArrayList<>();
        try{
            Currency c1 = Currency.getInstance(currency1);
            Currency c2 = Currency.getInstance(currency2);
            exchangeServices.forEach(openExchangeService -> results.add(openExchangeService.getExchange(c1,c2)));
            return new ResponseEntity<>(results, HttpStatus.OK);
        }catch (IllegalArgumentException e){
                throw new RuntimeException("Błędne dane");
        }

    }
    @RequestMapping(value = "/rates",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<String>> GETrates(@RequestParam(name = "c") List<String> currencies){
        List<String> results = new ArrayList<>();
        List<Currency> currencies1 = new ArrayList<>();
        try{
            currencies.forEach(currency->currencies1.add(Currency.getInstance(currency)));
            exchangeServices.forEach(openExchangeService -> results.add(openExchangeService.getExchange(currencies1)));
            return new ResponseEntity<>(results, HttpStatus.OK);
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Błędne dane");
        }
    }

    @RequestMapping(value = "/rate",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<String>> POSTrate(@RequestParam(name = "c1") String currency1, @RequestParam(name = "c2") String currency2){
        List<String> results = new ArrayList<>();
        try{
            Currency c1 = Currency.getInstance(currency1);
            Currency c2 = Currency.getInstance(currency2);
            exchangeServices.forEach(openExchangeService -> results.add(openExchangeService.getExchange(c1,c2)));
            return new ResponseEntity<>(results, HttpStatus.OK);
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Błędne dane");
        }
    }

    @RequestMapping(value = "/rates",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<String>> POSTrates(@RequestParam(name = "c") List<String> currencies){
        List<String> results = new ArrayList<>();
        List<Currency> currencies1 = new ArrayList<>();
        try{
            currencies.forEach(currency->currencies1.add(Currency.getInstance(currency)));
            exchangeServices.forEach(openExchangeService -> results.add(openExchangeService.getExchange(currencies1)));
            return new ResponseEntity<>(results, HttpStatus.OK);
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Błędne dane");
        }
    }

    @RequestMapping(value = "/money",method = RequestMethod.GET)
    public ResponseEntity<List<String>> GETmoney(
            @RequestParam(name = "m") Integer money,
            @RequestParam(name = "c1") String currency1,
            @RequestParam(name="c2") String currency2){
        if(money<0||money>1000){
            throw new RuntimeException("kwota powinna być między 0, a 1000");
        }
        List<String> results = new ArrayList<>();
        try{
            Currency c1 = Currency.getInstance(currency1);
            Currency c2 = Currency.getInstance(currency2);
            exchangeServices.forEach(openExchangeService -> results.add(openExchangeService.getExchange(BigDecimal.valueOf((double)money),c1,c2)));
            return new ResponseEntity<>(results, HttpStatus.OK);
        }catch (IllegalArgumentException e){
            e.getMessage();
            throw new RuntimeException(e.getMessage());
        }
    }

    @RequestMapping(value = "/date",method = RequestMethod.GET)
    public ResponseEntity<List<String>> GetDateMoney(
            @RequestParam(name = "d") String date,
            @RequestParam(name = "m") Integer money,
            @RequestParam(name = "c1") String currency1,
            @RequestParam(name="c2") String currency2){
        if(money<0||money>1000){
            throw new RuntimeException("kwota powinna być między 0, a 1000");
        }

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("Błędny format daty");
        }

        List<String> results = new ArrayList<>();
        try{
            Currency c1 = Currency.getInstance(currency1);
            Currency c2 = Currency.getInstance(currency2);
            exchangeServices.forEach(openExchangeService -> results.add(openExchangeService.getExchange(date,BigDecimal.valueOf((double)money),c1,c2)));
            return new ResponseEntity<>(results, HttpStatus.I_AM_A_TEAPOT);
        }catch (IllegalArgumentException e){
            e.getMessage();
            throw new RuntimeException(e.getMessage());
        }
    }

}
