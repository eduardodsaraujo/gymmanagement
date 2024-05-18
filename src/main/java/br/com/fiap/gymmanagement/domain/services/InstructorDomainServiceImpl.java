package br.com.fiap.gymmanagement.domain.services;

import br.com.fiap.gymmanagement.domain.dto.InstructorReponseDto;
import br.com.fiap.gymmanagement.domain.dto.InstructorRequestDto;
import br.com.fiap.gymmanagement.domain.entities.Instructor;
import br.com.fiap.gymmanagement.domain.exception.ResourceNotFoundException;
import br.com.fiap.gymmanagement.infrastructure.interfaces.InstructorDomainService;
import br.com.fiap.gymmanagement.infrastructure.repositories.InstructorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstructorDomainServiceImpl implements InstructorDomainService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public InstructorReponseDto create(InstructorRequestDto instructorRequestDto) {
        Instructor instructor = modelMapper.map(instructorRequestDto, Instructor.class);
        instructor = instructorRepository.save(instructor);
        return modelMapper.map(instructor, InstructorReponseDto.class);
    }

    @Override
    public List<InstructorReponseDto> findAll() {
        List<Instructor> instructors = instructorRepository.findAll();

        return instructors
                .stream()
                .map(instructor -> modelMapper.map(instructor, InstructorReponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public InstructorReponseDto findById(Integer instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found with id " + instructorId));
        return modelMapper.map(instructor, InstructorReponseDto.class);
    }

    @Override
    public InstructorReponseDto update(InstructorRequestDto instructorRequestDto, Integer instructorId) {
        Instructor instructor = modelMapper.map(instructorRequestDto, Instructor.class);
        instructor.setId(instructorId);
        instructorRepository.save(instructor);
        return modelMapper.map(instructor, InstructorReponseDto.class);
    }

    @Override
    public void delete(Integer id) {
        Instructor instructor = instructorRepository.findById(id).get();
        instructorRepository.delete(instructor);
    }

}
