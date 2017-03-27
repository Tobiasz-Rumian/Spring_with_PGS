package com.currencyExchange.service.impl;

import com.currencyExchange.service.OpenExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tobiasz Rumian on 21.03.2017.
 */
@Service
public class OpenCurrencyExchangeService implements OpenExchangeService {
    private String url="http://api.fixer.io/";
    private String latest="latest?";
    @Autowired
    private RestTemplate rest;

    public String getExchange(Currency currency1, Currency currency2){
        String base = "base="+currency1;
        String symbols = "symbols="+currency2;
        Map<String,Object> response = rest.getForObject(url+latest+base+"&"+symbols,HashMap.class);
        return response.toString();
    }

    public String getExchange(List<Currency> currencies){

        String base = "base="+currencies.get(0)+"&";
        currencies.remove(0);
        StringBuilder symbols=new StringBuilder();
        symbols.append("symbols=");
        currencies.forEach(currency ->symbols.append(currency).append(",") );
        Map<String,Object> response = rest.getForObject(url+latest+base+"&"+symbols,HashMap.class);
        return response.toString();
    }

    public String getExchange(BigDecimal value, Currency currency1, Currency currency2){
        String base = "base="+currency1;
        String symbols = "symbols="+currency2;
        Map<String,Object> response = rest.getForObject(url+latest+base+"&"+symbols,HashMap.class);
        String r =response.get("rates").toString();
        r=r.substring(r.indexOf("=")+1,r.indexOf("}"));
        BigDecimal d=BigDecimal.valueOf(Double.parseDouble(r));
        value=value.multiply(d);

        return value.toString();
    }
    public String getExchange(String date,BigDecimal value, Currency currency1, Currency currency2){
        date+="?";
        String base = "base="+currency1;
        String symbols = "symbols="+currency2;
        Map<String,Object> response = rest.getForObject(url+date+base+"&"+symbols,HashMap.class);
        String r =response.get("rates").toString();
        r=r.substring(r.indexOf("=")+1,r.indexOf("}"));
        BigDecimal d=BigDecimal.valueOf(Double.parseDouble(r));
        value=value.multiply(d);

        return value.toString();
    }
}
