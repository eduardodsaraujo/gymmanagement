package br.com.fiap.gymmanagement.instructors.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class Address {

    @Column(name = "street", length = 255, nullable = false)
    private String street;
    @Column(name = "city", length = 255, nullable = false)
    private String city;
    @Column(name = "state", length = 255, nullable = false)
    private String state;
    @Column(name = "postalCode", length = 255, nullable = false)
    private String postalCode;
}
