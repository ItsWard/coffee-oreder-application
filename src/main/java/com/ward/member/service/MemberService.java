package com.ward.member.service;

import com.ward.member.domain.Member;
import com.ward.member.web.dto.MemberPostDto;

public interface MemberService {
    Member save(MemberPostDto memberPostDto);
}
