package com.ward.coffee.service;

import com.ward.coffee.domain.Coffee;
import com.ward.coffee.web.dto.CoffeePostDto;
import com.ward.coffee.web.dto.CoffeeUpdateDto;

import java.util.Map;

public interface CoffeeService {
    Coffee save(CoffeePostDto coffeePostDto);

    Coffee update(Long id, CoffeeUpdateDto coffeeUpdateDto);

    Coffee findById(Long id);

    Map<Long, Coffee> findAll();

    void delete(Long id);

    void deleteAll();


}
