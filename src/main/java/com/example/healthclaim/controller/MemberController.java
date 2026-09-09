package com.example.healthclaim.controller;

import com.example.healthclaim.entity.Member;
import com.example.healthclaim.service.MemberService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
}
