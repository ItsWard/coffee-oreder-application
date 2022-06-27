package com.codestates.coffee.web;

import com.codestates.coffee.domain.Coffee;
import com.codestates.coffee.mapper.CoffeeMapper;
import com.codestates.coffee.service.CoffeeService;
import com.codestates.coffee.service.CoffeeServiceImpl;
import com.codestates.coffee.web.dto.CoffeePatchDto;
import com.codestates.coffee.web.dto.CoffeePostDto;
import com.codestates.coffee.web.dto.CoffeeResponseDto;
import com.codestates.member.domain.Member;
import com.codestates.member.web.dto.MemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor //생성자가 없어도 final로 주입해야하는 객체들을 자동으로 주입해줌
@RestController
@RequestMapping("/v1/coffees")
@Validated
public class CoffeeController {

    private final CoffeeService coffeeService;
    private final CoffeeMapper mapper;


    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDto coffeePostDto) {

        Coffee coffee = mapper.coffeePostDtoToMember(coffeePostDto);
        Coffee response = coffeeService.save(coffee);

        return new ResponseEntity<>(mapper.coffeeToMemberResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Positive long coffeeId,
                                      @Valid @RequestBody CoffeePatchDto coffeePatchDto) {
        Coffee coffee = coffeeService.findById(coffeeId);
        coffee.updateCoffee( mapper.coffeePatchDtoToMember(coffeePatchDto));


        return new ResponseEntity<>(mapper.coffeeToMemberResponseDto(coffee), HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {


        Coffee response = coffeeService.findById(coffeeId);
        // not implementation

        return new ResponseEntity<>(mapper.coffeeToMemberResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {

        List<Coffee> coffees = coffeeService.findAll();

        List<CoffeeResponseDto> response =
                coffees.stream()
                        .map(mapper::coffeeToMemberResponseDto)
                        .collect(Collectors.toList());
        // not implementation

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {
        // No need business logic
        coffeeService.delete(coffeeId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
