package br.com.fiap.gymmanagement.domain.dto;

import br.com.fiap.gymmanagement.domain.entities.Address;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InstructorReponseDto {

    private Integer id;
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;
    private String specialization;
    private Address address;
}
