package com.codestates.member.domain.repository;

import com.codestates.member.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    Map<Long, Member> memberMap = new HashMap<>();
    Long idSequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++idSequence);
        memberMap.put(member.getId(), member);
        return member;
    }

    @Override
    public Member update(Long id, Member member) {
        return findById(id).updateMember(member);
    }

    @Override
    public void delete(Long id) {
        memberMap.remove(id);
    }

    @Override
    public Member findById(Long id) {
        return memberMap.get(id);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(memberMap.values());
    }
}
