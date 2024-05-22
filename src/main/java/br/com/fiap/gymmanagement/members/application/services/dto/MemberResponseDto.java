package br.com.fiap.gymmanagement.members.application.services.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberResponseDto {

    private Integer id;
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;
    private String street;
    private String city;
    private String state;
    private String postalCode;
}
