package com.codestates.coffee.domain.repository;

import com.codestates.coffee.domain.Coffee;
import com.codestates.member.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryCoffeeRepository implements CoffeeRepository{
    Map<Long, Coffee> coffeeMap = new HashMap<>();
    Long idSequence = 0L;

    @Override
    public Coffee save(Coffee coffee) {
        coffee.setId(++idSequence);
        coffeeMap.put(coffee.getId(), coffee);
        return coffee;
    }

    @Override
    public Coffee update(Long id, Coffee coffee) {
        return findById(id).updateCoffee(coffee);
    }

    @Override
    public void delete(Long id) {
        coffeeMap.remove(id);
    }

    @Override
    public Coffee findById(Long id) {
        return coffeeMap.get(id);
    }

    @Override
    public List<Coffee> findAll() {
        return new ArrayList<>(coffeeMap.values());
    }
}
