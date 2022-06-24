package com.ward.coffee.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CoffeeUpdateDto {
    private String korName;
    private String engName;
    private Integer price;

}
