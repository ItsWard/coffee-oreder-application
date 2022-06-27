package com.codestates.member.domain;


import lombok.*;

@Getter
@Setter
public class Member {

    private Long id;
    private String email;
    private String name;
    private String phone;


    public Member updateMember(Member member) {
        if(member.getName() != null)
            this.name = member.getName();
        if(member.getEmail() != null)
            this.email = member.getEmail();
        if (member.getEmail() != null)
            this.phone = member.getPhone();

        return this;
    }

    @Builder
    public Member(String email, String name, String phone) {
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
