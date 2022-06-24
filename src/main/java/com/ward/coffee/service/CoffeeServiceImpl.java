package com.ward.coffee.service;

import com.ward.coffee.domain.Coffee;
import com.ward.coffee.domain.repository.CoffeeRepository;
import com.ward.coffee.web.dto.CoffeePostDto;
import com.ward.coffee.web.dto.CoffeeUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService{

    private final CoffeeRepository coffeeRepository;

    @Override
    public Coffee save(CoffeePostDto CoffeePostDto) {
        return coffeeRepository.save(CoffeePostDto.toEntity());
    }

    @Override
    public Coffee update(Long id, CoffeeUpdateDto coffeeUpdateDto) {
            Coffee coffee = coffeeRepository.findById(id);
        coffee.update(coffeeUpdateDto.getKorName(), coffeeUpdateDto.getEngName(), coffeeUpdateDto.getPrice());
        return coffee;
    }

    @Override
    public Coffee findById(Long id) {
        return coffeeRepository.findById(id);
    }

    @Override
    public Map<Long, Coffee> findAll() {
        return coffeeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        coffeeRepository.delete(id);
    }

    @Override
    public void deleteAll() {
        coffeeRepository.deleteAll();
    }


}
