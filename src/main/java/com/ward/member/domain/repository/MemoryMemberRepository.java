package com.ward.member.domain.repository;

import com.ward.member.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    Long idSequence = 0L;

    Map<Long, Member> memberStore = new HashMap<>();


    @Override
    public Member save(Member member) {
        member.setId(++idSequence); //
        memberStore.put(member.getId(), member);
        return member;
    }

    @Override
    public void delete(Long id) {
        memberStore.remove(id);
    }

    @Override
    public Member update(Long id, Member memberEntity) {

        findById(id).update(memberEntity.getEmail(), memberEntity.getPhone(), memberEntity.getName());
        return findById(id);
    }

    @Override
    public Member findById(Long id) {
        return memberStore.get(id);
    }

    @Override
    public Map<Long, Member> findAll() {
        return memberStore;
    }


}
