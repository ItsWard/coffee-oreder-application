package com.codestates.coffee.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Coffee {

    private Long id;
    private String korName;
    private String engName;
    private Integer price;


    public Coffee updateCoffee(Coffee coffee) {
        if(coffee.getKorName() != null)
            this.korName = coffee.getKorName();
        if(coffee.getEngName() != null)
            this.engName = coffee.getEngName();
        if(coffee.getPrice() != null)
            this.price = coffee.getPrice();
        return this;
    }
}
