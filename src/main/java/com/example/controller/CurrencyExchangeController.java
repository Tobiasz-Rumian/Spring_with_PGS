package com.example.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Currency;

/**
 * Created by zekori on 07.03.17.
 */
@RestController
public class CurrencyExchangeController {

    @RequestMapping("/{nnumber}")
    public Long multiplyByTwo(@PathVariable Long number){

        return number*2;
    }

    @RequestMapping("/currency/{value}")
    public String addCurrencySignature(@PathVariable Long value,
                                       @RequestParam("currency") String currency){

        return value+currency;
    }
    @RequestMapping("/currencyValue/{value}/{multiplier}")
    public String valueOf(@PathVariable Long value,
                          @PathVariable Long multiplier,
                          @RequestParam("from") String from,
                          @RequestParam("to") String to){

        try{
            Currency currencyFrom= Currency.getInstance(from);
            Currency currencyTo=Currency.getInstance(to);
            return value+from+" = "+value*multiplier+to;
        }catch (IllegalArgumentException e){
            throw new RuntimeException("Something went wrong");
        }
    }
}
