package com.codestates.coffee.service;

import com.codestates.coffee.domain.Coffee;

import java.util.List;

public interface CoffeeService {

    Coffee save(Coffee coffee);

    Coffee update(Coffee coffee);

    void delete(Long id);

    Coffee findById(Long id);

    List<Coffee> findAll();

}
