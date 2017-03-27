package com.currencyExchange.repository;

import com.currencyExchange.entity.Weather;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CrudRepository<Weather,Long> {

}
