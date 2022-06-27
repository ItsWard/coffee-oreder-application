package com.codestates.member;

import com.codestates.member.domain.repository.MemberRepository;
import com.codestates.member.domain.repository.MemoryMemberRepository;
import com.codestates.member.service.MemberService;
import com.codestates.member.service.MemberServiceImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {

    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

}
