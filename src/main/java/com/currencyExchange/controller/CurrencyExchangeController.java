package com.currencyExchange.controller;

import com.currencyExchange.dto.CurrencyDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Created by zekori on 07.03.17.
 */
@RestController //With @RestController we don't need to add @ResponseBody to create a simple website.
public class CurrencyExchangeController {

    @RequestMapping("/{number}")
    public Long multiplyByTwo(@PathVariable Long number) {

        return number * 2;
    }

    @RequestMapping("/currency/{value}")
    public String addCurrencySignature(@PathVariable Long value,
                                       @RequestParam("currency") String currency) {

        return value + currency;
    }

    @RequestMapping("/currencyValue/{value}/{multiplier}")
    //TODO: Add ability to type numbers with decimal point. {m:.+} is read as String
    public String valueOf(@PathVariable Long value,
                          @PathVariable Long multiplier,
                          @RequestParam("from") String from,
                          @RequestParam("to") String to) {

        try {
            Currency currencyFrom = Currency.getInstance(from);
            Currency currencyTo = Currency.getInstance(to);
            return value + " " + currencyFrom.toString() + " = " + value * multiplier + " " + currencyTo.toString();
        } catch (IllegalArgumentException e) {
            e.getMessage();//if needed
            throw new RuntimeException("Something went wrong");
        }
    }

    @RequestMapping("/dto")
    public CurrencyDTO returnDTO(){
        return CurrencyDTO.
                builder().
                currency(Currency.getInstance("PLN")).
                value(new BigDecimal(123.32)).
                build();
    }

}
