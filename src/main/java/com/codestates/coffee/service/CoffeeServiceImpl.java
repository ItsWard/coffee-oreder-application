package com.codestates.coffee.service;

import com.codestates.coffee.domain.Coffee;
import com.codestates.coffee.domain.repository.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Override
    public Coffee save(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    @Override
    public Coffee update(Coffee coffee) {
        return coffeeRepository.update(coffee.getId(), coffee);
    }

    @Override
    public void delete(Long id) {
        coffeeRepository.delete(id);
    }

    @Override
    public Coffee findById(Long id) {
        return coffeeRepository.findById(id);
    }

    @Override
    public List<Coffee> findAll() {
        return coffeeRepository.findAll();
    }
}
