package com.codestates.coffee;

import com.codestates.coffee.domain.repository.CoffeeRepository;
import com.codestates.coffee.domain.repository.MemoryCoffeeRepository;
import com.codestates.coffee.service.CoffeeService;
import com.codestates.coffee.service.CoffeeServiceImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoffeeConfig {

    CoffeeRepository coffeeRepository(){
        return new MemoryCoffeeRepository();
    }

    CoffeeService coffeeService(){
        return new CoffeeServiceImpl(coffeeRepository());
    }

}
