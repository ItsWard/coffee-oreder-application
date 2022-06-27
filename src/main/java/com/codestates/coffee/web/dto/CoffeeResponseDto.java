package com.codestates.coffee.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CoffeeResponseDto {

    private Long id;
    private String korName;
    private String engName;
    private Integer price;

    @Builder
    public CoffeeResponseDto(Long id, String korName, String engName, Integer price) {
        this.id = id;
        this.korName = korName;
        this.engName = engName;
        this.price = price;
    }
}
