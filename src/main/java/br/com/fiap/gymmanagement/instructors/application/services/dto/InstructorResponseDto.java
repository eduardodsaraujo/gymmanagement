package br.com.fiap.gymmanagement.instructors.application.services.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InstructorResponseDto {

    private Integer id;
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;
    private String specialization;
    private String street;
    private String city;
    private String state;
    private String postalCode;
}
