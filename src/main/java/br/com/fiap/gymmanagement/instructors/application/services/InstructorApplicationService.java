package br.com.fiap.gymmanagement.instructors.application.services;

import br.com.fiap.gymmanagement.instructors.application.services.dto.InstructorResponseDto;
import br.com.fiap.gymmanagement.instructors.application.services.dto.InstructorRequestDto;

import java.util.List;


public interface InstructorApplicationService {

    InstructorResponseDto create (InstructorRequestDto instructorRequestDto);
    List<InstructorResponseDto> findAll();
    InstructorResponseDto findById(Integer instructorId);
    InstructorResponseDto update(InstructorRequestDto instructorRequestDto, Integer instructorId);
    void delete(Integer id);
}
