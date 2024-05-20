package br.com.fiap.gymmanagement.instructors.application.services;

import br.com.fiap.gymmanagement.instructors.application.services.dto.InstructorResponseDto;
import br.com.fiap.gymmanagement.instructors.application.services.dto.InstructorRequestDto;
import br.com.fiap.gymmanagement.instructors.domain.entities.Instructor;
import br.com.fiap.gymmanagement.instructors.domain.exception.ResourceNotFoundException;
import br.com.fiap.gymmanagement.instructors.domain.repositories.InstructorRepository;
import br.com.fiap.gymmanagement.instructors.infrastructure.components.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorApplicationServiceImpl implements InstructorApplicationService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public InstructorResponseDto create(InstructorRequestDto instructorRequestDto) {
        Instructor instructor = mapper.toEntity(instructorRequestDto);
        instructor = instructorRepository.save(instructor);

        return mapper.toResponseDto(instructor);
    }

    @Override
    public List<InstructorResponseDto> findAll() {
        List<Instructor> instructors = instructorRepository.findAll();

        return instructors
                .stream()
                .map(instructor -> mapper.toResponseDto(instructor))
                .collect(Collectors.toList());
    }

    @Override
    public InstructorResponseDto findById(Integer instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found with id " + instructorId));
        return mapper.toResponseDto(instructor);
    }

    @Override
    public InstructorResponseDto update(InstructorRequestDto instructorRequestDto, Integer instructorId) {
        Instructor instructor = mapper.toEntity(instructorRequestDto);
        instructor.setId(instructorId);

        instructorRepository.save(instructor);
        return mapper.toResponseDto(instructor);
    }

    @Override
    public void delete(Integer id) {
        Instructor instructor = instructorRepository.findById(id).get();
        instructorRepository.delete(instructor);
    }

}
