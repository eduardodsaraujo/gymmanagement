package br.com.fiap.gymmanagement.instructors.infrastructure.components;

import br.com.fiap.gymmanagement.instructors.application.services.dto.InstructorRequestDto;
import br.com.fiap.gymmanagement.instructors.application.services.dto.InstructorResponseDto;
import br.com.fiap.gymmanagement.instructors.domain.entities.Address;
import br.com.fiap.gymmanagement.instructors.domain.entities.Instructor;
import org.springframework.stereotype.Component;
@Component
public class Mapper {

    public InstructorResponseDto toResponseDto(Instructor instructor) {
        InstructorResponseDto instructorResponseDto = new InstructorResponseDto();
        instructorResponseDto.setId(instructor.getId());
        instructorResponseDto.setName(instructor.getName());
        instructorResponseDto.setCpf(instructor.getCpf());
        instructorResponseDto.setBirthDate(instructor.getBirthDate());
        instructorResponseDto.setPhoneNumber(instructor.getPhoneNumber());
        instructorResponseDto.setEmail(instructor.getEmail());
        instructorResponseDto.setSpecialization(instructor.getSpecialization());
        instructorResponseDto.setStreet(instructor.getAddress().getStreet());
        instructorResponseDto.setCity(instructor.getAddress().getCity());
        instructorResponseDto.setState(instructor.getAddress().getState());
        instructorResponseDto.setPostalCode(instructor.getAddress().getPostalCode());

        return instructorResponseDto;
    }


    public Instructor toEntity(InstructorRequestDto instructorRequestDto) {
        Instructor instructor = new Instructor();
        instructor.setName(instructorRequestDto.getName());
        instructor.setCpf(instructorRequestDto.getCpf());
        instructor.setBirthDate(instructorRequestDto.getBirthDate());
        instructor.setPhoneNumber(instructorRequestDto.getPhoneNumber());
        instructor.setEmail(instructorRequestDto.getEmail());
        instructor.setSpecialization(instructorRequestDto.getSpecialization());

        Address address = new Address();
        address.setStreet(instructorRequestDto.getStreet());
        address.setCity(instructorRequestDto.getCity());
        address.setState(instructorRequestDto.getState());
        address.setPostalCode(instructorRequestDto.getPostalCode());
        instructor.setAddress(address);

        return instructor;
    }
}