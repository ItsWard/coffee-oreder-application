package com.codestates.coffee.domain.repository;

import com.codestates.coffee.domain.Coffee;

import java.util.List;

public interface CoffeeRepository {

    Coffee save(Coffee coffee);

    Coffee update(Long id, Coffee coffee);

    void delete(Long id);

    Coffee findById(Long id);

    List<Coffee> findAll();
}
