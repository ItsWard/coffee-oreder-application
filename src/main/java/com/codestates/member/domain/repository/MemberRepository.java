package com.codestates.member.domain.repository;

import com.codestates.member.domain.Member;

import java.util.List;

public interface MemberRepository {

    Member save(Member member);

    Member update(Long id, Member member);

    void delete(Long id);

    Member findById(Long id);

    List<Member> findAll();

}
