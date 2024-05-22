package br.com.fiap.gymmanagement.members.infrastructure.components;

import br.com.fiap.gymmanagement.instructors.domain.entities.Address;
import br.com.fiap.gymmanagement.members.application.services.dto.MemberRequestDto;
import br.com.fiap.gymmanagement.members.application.services.dto.MemberResponseDto;
import br.com.fiap.gymmanagement.members.domain.entities.Member;

public class Mapper {

    public MemberResponseDto toResponseDto(Member member) {
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto.setId(member.getId());
        memberResponseDto.setName(member.getName());
        memberResponseDto.setCpf(member.getCpf());
        memberResponseDto.setBirthDate(member.getBirthDate());
        memberResponseDto.setPhoneNumber(member.getPhoneNumber());
        memberResponseDto.setEmail(member.getEmail());
        memberResponseDto.setStreet(member.getAddress().getStreet());
        memberResponseDto.setCity(member.getAddress().getCity());
        memberResponseDto.setState(member.getAddress().getState());
        memberResponseDto.setPostalCode(member.getAddress().getPostalCode());

        return memberResponseDto;
    }

    public Member toEntity(MemberRequestDto memberRequestDto) {
        Member member = new Member();
        member.setName(memberRequestDto.getName());
        member.setCpf(memberRequestDto.getCpf());
        member.setBirthDate(memberRequestDto.getBirthDate());
        member.setPhoneNumber(memberRequestDto.getPhoneNumber());
        member.setEmail(memberRequestDto.getEmail());

        Address address = new Address();
        address.setStreet(memberRequestDto.getStreet());
        address.setCity(memberRequestDto.getCity());
        address.setState(memberRequestDto.getState());
        address.setPostalCode(memberRequestDto.getPostalCode());
        member.setAddress(address);

        return member;
    }
}
