package br.com.fiap.gymmanagement.instructors.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tb_instructor")
@Data
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 255, nullable = false)
    private String name;
    @Column(name = "cpf", length = 15, nullable = false)
    private String cpf;
    @Column(name = "birthDate", length = 60, nullable = false)
    private LocalDate birthDate;
    @Column(name = "phoneNumber", length = 15, nullable = false)
    private String phoneNumber;
    @Column(name = "email", length = 60, nullable = false, unique = true)
    private String email;
    @Column(name = "specialization", length = 60, nullable = false)
    private String specialization;

    @Embedded
    private Address address;


}
