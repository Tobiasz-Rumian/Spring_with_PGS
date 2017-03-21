package com.currencyExchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CurrencyExchangeApplication {


	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeApplication.class, args);
	}

	@Bean
	String currencyType(){
	    return "currency type: ";
    }

    @Bean
    RestTemplate RestTemplate(){
       return new RestTemplateBuilder().build();
    }

}
