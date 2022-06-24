package com.ward.coffee.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Coffee {

    private Long id;
    private String korName;
    private String engName;
    private Integer price;

    @Builder
    public Coffee(String korName, String engName, Integer price) {
        this.korName = korName;
        this.engName = engName;
        this.price = price;
    }

    public Coffee update(String korName, String engName, Integer price) {

        if(korName != null )
            this.korName = korName;
        if(engName != null)
            this.engName = engName;
        if(price != null)
            this.price = price;

        return this;
    }

}
