package com.ward.member.service;

import com.ward.member.domain.Member;
import com.ward.member.domain.repository.MemberRepository;
import com.ward.member.domain.repository.MemoryMemberRepository;
import com.ward.member.web.dto.MemberPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public Member save(MemberPostDto memberPostDto) {

        Member member = Member.builder()
                .phone(memberPostDto.getPhone())
                .name(memberPostDto.getName())
                .email(memberPostDto.getEmail())
                .build();

        return memberRepository.save(member);
    }
}
