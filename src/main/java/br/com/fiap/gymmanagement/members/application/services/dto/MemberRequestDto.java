package br.com.fiap.gymmanagement.members.application.services.dto;


import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberRequestDto {

    @Size(min=8, max=255, message = "Inform the full name, from 8 to 255 characters.")
    @NotBlank(message = "Please provide the full name.")
    private String name;

    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "Please provide the cpf in the 'XXX.XXX.XXX-XX' format.")
    @NotBlank(message = "Please provide the CPF")
    private String cpf;

    @NotNull(message = "Please provide the birth date in the 'yyyy-MM-dd' format.")
    private LocalDate birthDate;

    @NotBlank(message = "Please provide the phone number")
    @Pattern(regexp = "^\\(\\d{2}\\)\\d{5}-\\d{4}$",
            message = "Please provide the birth date in the '(xx)xxxxx-xxxx' format.")
    private String phoneNumber;

    @Email(message = "Please provide a valid email address.")
    @NotBlank(message = "Please, provide a email.")
    private String email;

    @NotBlank(message = "Please, provide a street.")
    private String street;

    @NotBlank(message = "Please, provide a city.")
    private String city;

    @NotBlank(message = "Please, provide a state.")
    private String state;

    @NotBlank(message = "Please, provide a postalcode.")
    private String postalCode;
}
