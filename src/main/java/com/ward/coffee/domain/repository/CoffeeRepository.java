package com.ward.coffee.domain.repository;

import com.ward.coffee.domain.Coffee;

import java.util.Map;

public interface CoffeeRepository {


    Coffee save(Coffee coffee);

    Coffee findById(Long id);

    Map<Long, Coffee> findAll();

    void delete(Long id);

    void deleteAll();

}
