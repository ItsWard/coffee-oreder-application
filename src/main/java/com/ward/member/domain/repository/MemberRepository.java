package com.ward.member.domain.repository;

import com.ward.member.domain.Member;

import java.util.HashMap;
import java.util.Map;


public interface MemberRepository {


    Member save(Member member);

    void delete(Long id);

    Member update(Long id, Member member);

    Member findById(Long id);

    Map<Long, Member> findAll();

}
