package com.codestates.member.service;


import com.codestates.member.domain.Member;

import java.util.List;

public interface MemberService {

    Member save(Member member);

    Member update(Member member);

    Member findById(Long id);

    List<Member> findAll();

    void delete(Long id);

}
