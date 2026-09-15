package com.example.healthclaim.service;

import com.example.healthclaim.dto.MemberRequestDTO;
import com.example.healthclaim.dto.MemberResponseDTO;
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

    public MemberResponseDTO createMember(MemberRequestDTO request) {

        Member member = new Member();

        member.setName(request.getName());
        member.setEmail(request.getEmail());
        member.setPhone(request.getPhone());
        member.setPolicyNumber(request.getPolicyNumber());
        member.setStatus(request.getStatus());

        Member savedMember = memberRepository.save(member);

        return new MemberResponseDTO(
                savedMember.getId(),
                savedMember.getName(),
                savedMember.getEmail(),
                savedMember.getPhone(),
                savedMember.getPolicyNumber(),
                savedMember.getStatus()
        );
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
