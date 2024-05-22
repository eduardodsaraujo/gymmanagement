package br.com.fiap.gymmanagement.members.application.services;

import br.com.fiap.gymmanagement.instructors.application.services.dto.InstructorRequestDto;
import br.com.fiap.gymmanagement.instructors.application.services.dto.InstructorResponseDto;
import br.com.fiap.gymmanagement.instructors.domain.entities.Instructor;
import br.com.fiap.gymmanagement.instructors.domain.exception.ResourceNotFoundException;
import br.com.fiap.gymmanagement.members.application.services.dto.MemberRequestDto;
import br.com.fiap.gymmanagement.members.application.services.dto.MemberResponseDto;
import br.com.fiap.gymmanagement.members.domain.entities.Member;
import br.com.fiap.gymmanagement.members.domain.repositories.MemberRepository;
import br.com.fiap.gymmanagement.members.infrastructure.components.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class MemberApplicationServiceImpl implements MemberApplicationService{

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private Mapper mapper;

    @Override
    public MemberResponseDto create(MemberRequestDto memberRequestDto) {
        Member member = mapper.toEntity(memberRequestDto);
        member = memberRepository.save(member);
        return mapper.toResponseDto(member);
    }

    @Override
    public List<MemberResponseDto> findAll() {
        List<Member> members = memberRepository.findAll();

        return members
                .stream()
                .map(member -> mapper.toResponseDto(member))
                .collect(Collectors.toList());
    }

    @Override
    public MemberResponseDto findById(Integer memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id " + memberId));
        return mapper.toResponseDto(member);
    }

    @Override
    public MemberResponseDto update(MemberRequestDto memberRequestDto, Integer memberId) {
        Member member = mapper.toEntity(memberRequestDto);
        member.setId(memberId);

        memberRepository.save(member);
        return mapper.toResponseDto(member);
    }

    @Override
    public void delete(Integer id) {
        Member member = memberRepository.findById(id).get();
        memberRepository.delete(member);
    }
}
