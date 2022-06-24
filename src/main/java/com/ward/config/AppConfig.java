package com.ward.config;

import com.ward.coffee.domain.repository.CoffeeRepository;
import com.ward.coffee.domain.repository.MemoryCoffeeRepository;
import com.ward.coffee.service.CoffeeService;
import com.ward.coffee.service.CoffeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CoffeeService coffeeService() {
        return new CoffeeServiceImpl(coffeeRepository());
    }

    private CoffeeRepository coffeeRepository() {
        return new MemoryCoffeeRepository();
    }
}
