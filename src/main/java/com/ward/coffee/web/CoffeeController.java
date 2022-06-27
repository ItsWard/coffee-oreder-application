package com.ward.coffee.web;

import com.ward.coffee.domain.Coffee;

import com.ward.coffee.service.CoffeeService;
import com.ward.coffee.web.dto.CoffeePostDto;
import com.ward.coffee.web.dto.CoffeeUpdateDto;
import com.ward.handler.ex.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/coffees") //클래스 위에 사용되는 기본 주소를 의미
public class CoffeeController {


    private final CoffeeService coffeeService;

    @PostMapping //Create 커피의 정보를 추가한다.
    public ResponseEntity postCoffee(@RequestBody CoffeePostDto coffeePostDto) {
        Coffee coffee = coffeeService.save(coffeePostDto);
         if(coffee.getPrice() < 5000)
             throw new CustomException("돈이 적어");
        return new ResponseEntity<>(coffee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity responseAllCoffees(){
        return new ResponseEntity<>(coffeeService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteAllCoffees(){
        coffeeService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/{coffee-id}")
    public ResponseEntity responseCoffee(@PathVariable("coffee-id") Long coffeeId){
        return new ResponseEntity<>(coffeeService.findById(coffeeId), HttpStatus.OK);
    }

    @PutMapping("/{coffee-id}")
    public ResponseEntity updateCoffee(@PathVariable("coffee-id") Long coffeeId,
                                         @RequestBody CoffeeUpdateDto coffeeUpdateDto){
        return new ResponseEntity<>(coffeeService.update(coffeeId, coffeeUpdateDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") Long coffeeId) {
        coffeeService.delete(coffeeId);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/v1/coffees"));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }


}
