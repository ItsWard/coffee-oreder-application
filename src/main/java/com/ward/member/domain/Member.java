package com.ward.member.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
public class Member {


    private Long id;
    private String email;
    private String phone;
    private String name;

    @Builder
    public Member(String email, String phone, String name) {
        this.email = email;
        this.phone = phone;
        this.name = name;
    }

    public void update(String email, String phone, String name){
        if(email != null)
            this.email = email;
        if(phone != null)
            this.phone = phone;
        if(name != null)
            this.name = name;
    }

}
