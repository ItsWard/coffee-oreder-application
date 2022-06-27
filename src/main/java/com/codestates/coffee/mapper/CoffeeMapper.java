package com.codestates.coffee.mapper;

import com.codestates.coffee.domain.Coffee;
import com.codestates.coffee.web.dto.CoffeePatchDto;
import com.codestates.coffee.web.dto.CoffeePostDto;
import com.codestates.coffee.web.dto.CoffeeResponseDto;
import com.codestates.member.domain.Member;
import com.codestates.member.web.dto.MemberPatchDto;
import com.codestates.member.web.dto.MemberPostDto;
import com.codestates.member.web.dto.MemberResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {

    Coffee coffeePostDtoToMember(CoffeePostDto coffeePostDto);
    Coffee coffeePatchDtoToMember(CoffeePatchDto coffeePatchDto);
    CoffeeResponseDto coffeeToMemberResponseDto(Coffee coffee);

}
