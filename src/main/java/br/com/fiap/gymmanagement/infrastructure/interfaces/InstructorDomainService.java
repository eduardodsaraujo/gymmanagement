package br.com.fiap.gymmanagement.infrastructure.interfaces;

import br.com.fiap.gymmanagement.domain.dto.InstructorReponseDto;
import br.com.fiap.gymmanagement.domain.dto.InstructorRequestDto;

import java.util.List;


public interface InstructorDomainService {

    InstructorReponseDto create (InstructorRequestDto instructorRequestDto);
    List<InstructorReponseDto> findAll();
    InstructorReponseDto findById(Integer instructorId);
    InstructorReponseDto update(InstructorRequestDto instructorRequestDto, Integer instructorId);
    void delete(Integer id);
}
