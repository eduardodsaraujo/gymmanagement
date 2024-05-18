package br.com.fiap.gymmanagement.application.controller;

import br.com.fiap.gymmanagement.domain.dto.InstructorReponseDto;
import br.com.fiap.gymmanagement.domain.dto.InstructorRequestDto;
import br.com.fiap.gymmanagement.infrastructure.interfaces.InstructorDomainService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Instructors")
@RequestMapping(value = "/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorDomainService instructorDomainService;

    @PostMapping()
    @Operation(summary = "Add a new instructor", description = "Create a new instructor and store it in the database")
    public ResponseEntity<InstructorReponseDto> create
            (@RequestBody @Valid InstructorRequestDto dto) {

        InstructorReponseDto response = instructorDomainService.create(dto);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping()
    @Operation(summary = "Get all instructors", description = "Retrieve a list of all available instructors")
    public ResponseEntity<List<InstructorReponseDto>> findAll(){
        List<InstructorReponseDto> response = instructorDomainService.findAll();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an instructor by ID", description = "Retrieve a specific instructor by their unique ID")
    public ResponseEntity<InstructorReponseDto> findById(@PathVariable("id" ) Integer id){
        InstructorReponseDto response = instructorDomainService.findById(id);
        return ResponseEntity.status(200).body(response);
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an instructor", description = "Delete an instructor from the database by their ID")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        instructorDomainService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update an existing instructor", description = "Update the details of an existing instructor by their ID")
    public ResponseEntity<InstructorReponseDto> update(@PathVariable("id") Integer id, @RequestBody @Valid InstructorRequestDto dto){
        InstructorReponseDto response = instructorDomainService.update(dto, id);
        return ResponseEntity.status(200).body(response);
    }
}
