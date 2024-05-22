package br.com.fiap.gymmanagement.members.application.services;

import br.com.fiap.gymmanagement.members.application.services.dto.MemberRequestDto;
import br.com.fiap.gymmanagement.members.application.services.dto.MemberResponseDto;

import java.util.List;

public interface MemberApplicationService {

    MemberResponseDto create (MemberRequestDto memberRequestDto);
    List<MemberResponseDto> findAll();
    MemberResponseDto findById(Integer memberId);
    MemberResponseDto update(MemberRequestDto memberRequestDto, Integer memberId);
    void delete(Integer id);

}
