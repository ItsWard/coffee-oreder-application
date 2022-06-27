package com.codestates.member.mapper;

import com.codestates.member.domain.Member;
import com.codestates.member.web.dto.MemberPatchDto;
import com.codestates.member.web.dto.MemberPostDto;
import com.codestates.member.web.dto.MemberResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberPostDtoToMember(MemberPostDto memberPostDto);

    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);

    MemberResponseDto memberToMemberResponseDto(Member member);
}
