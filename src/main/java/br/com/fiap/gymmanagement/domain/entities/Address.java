package br.com.fiap.gymmanagement.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(hidden = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    @Column(name = "street", length = 255, nullable = false)
    private String street;
    @Column(name = "city", length = 255, nullable = false)
    private String city;
    @Column(name = "state", length = 255, nullable = false)
    private String state;
    @Column(name = "postalCode", length = 255, nullable = false)
    private String postalCode;

    @OneToOne(mappedBy = "address")
    @Schema(hidden = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Instructor instructor;
}
