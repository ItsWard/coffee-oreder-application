package com.ward.coffee.domain.repository;

import com.ward.coffee.domain.Coffee;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryCoffeeRepository implements CoffeeRepository{ //임시로 테스트하기위한 DB

    Map<Long, Coffee> coffeeMap = new HashMap<>();
    Long idSequence = 0L;


    @Override
    public Coffee save(Coffee coffee) {
        coffee.setId(++idSequence);
        coffeeMap.put(coffee.getId(), coffee);
        return coffee;
    }

    @Override
    public Coffee findById(Long id) {
        return coffeeMap.get(id);
    }

    @Override
    public Map<Long, Coffee> findAll() {
        return coffeeMap;
    }


    @Override
    public void delete(Long id) {
        coffeeMap.remove(id);
    }

    @Override
    public void deleteAll() {
        coffeeMap.clear();
        idSequence = 0L;
    }
}
