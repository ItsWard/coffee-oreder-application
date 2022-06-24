package com.ward.coffee.web.dto;

import com.ward.coffee.domain.Coffee;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CoffeePostDto {

    private String korName;
    private String engName;
    private Integer price;

    @Builder
    public CoffeePostDto(String korName, String engName, Integer price) {
        this.korName = korName;
        this.engName = engName;
        this.price = price;
    }

    public Coffee toEntity(){
        return Coffee.builder()
                .korName(korName)
                .engName(engName)
                .price(price)
                .build();
    }

    @Override
    public String toString() {
        return "CoffeePostDto{" +
                "korName='" + korName + '\'' +
                ", engName='" + engName + '\'' +
                ", price=" + price +
                '}';
    }
}
