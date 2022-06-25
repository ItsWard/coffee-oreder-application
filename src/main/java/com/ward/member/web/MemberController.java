package com.ward.member.web;

import com.ward.member.domain.Member;
import com.ward.member.domain.repository.MemberRepository;
import com.ward.member.service.MemberService;
import com.ward.member.web.dto.MemberPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor //클래스 내 필드안에 있는 private final 데이터를 Bean에 등록 + 초기화(new)
@RestController
@RequestMapping("/v1/members")
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    //RequestParam => Body 데이터 하나
    //RequestBody => json
    @PostMapping // 새로운 멤버를 저장함
    public ResponseEntity postMember(@RequestBody MemberPostDto memberPostDto) {

        return new ResponseEntity<>(memberService.save(memberPostDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getMembers() {

        return new ResponseEntity(memberRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping({"/{memberId}"})
    public ResponseEntity getMember(@PathVariable("memberId") Long id) { //uri

        return new ResponseEntity<>(memberRepository.findById(id), HttpStatus.OK);
    }


    //---------------- 여기서 부터 아래에 코드를 구현하세요! -------------------//
    // 1. 회원 정보 수정을 위한 핸들러 메서드 구현
    @PatchMapping("/{member-id}")
    public ResponseEntity updateMember(@PathVariable("member-id") Long id,
                                       @RequestParam(value = "email", required = false) String email,
                                       @RequestParam(value = "name", required = false) String name,
                                       @RequestParam(value = "phone", required = false) String phone) {

        Member member = Member.builder()
                .email(email)
                .name(name)
                .phone(phone)
                .build();

        return new ResponseEntity<>(memberRepository.update(id, member), HttpStatus.OK);
    }

    // 2. 회원 정보 삭제를 위한 핸들러 메서드 구현
    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") Long id) {

        memberRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
