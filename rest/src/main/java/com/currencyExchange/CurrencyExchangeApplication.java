package com.currencyExchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.currencyExchange.*")
@EnableJpaRepositories(basePackages = {"com.currencyExchange.*"})
@ComponentScan({"com.currencyExchange.*"})
@EntityScan(basePackages = {"com.currencyExchange.*"})
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
