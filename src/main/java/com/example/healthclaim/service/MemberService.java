package com.example.healthclaim.service;

import com.example.healthclaim.entity.Member;
import com.example.healthclaim.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElse(null);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
