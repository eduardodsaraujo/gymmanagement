package br.com.fiap.gymmanagement.instructors.api.controllers;

import br.com.fiap.gymmanagement.instructors.application.services.dto.InstructorResponseDto;
import br.com.fiap.gymmanagement.instructors.application.services.dto.InstructorRequestDto;
import br.com.fiap.gymmanagement.instructors.application.services.InstructorApplicationService;
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
    private InstructorApplicationService instructorApplicationService;

    @PostMapping()
    @Operation(summary = "Add a new instructor", description = "Create a new instructor and store it in the database")
    public ResponseEntity<InstructorResponseDto> create
            (@RequestBody @Valid InstructorRequestDto dto) {

        InstructorResponseDto response = instructorApplicationService.create(dto);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping()
    @Operation(summary = "Get all instructors", description = "Retrieve a list of all available instructors")
    public ResponseEntity<List<InstructorResponseDto>> findAll(){
        List<InstructorResponseDto> response = instructorApplicationService.findAll();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an instructor by ID", description = "Retrieve a specific instructor by their unique ID")
    public ResponseEntity<InstructorResponseDto> findById(@PathVariable("id" ) Integer id){
        InstructorResponseDto response = instructorApplicationService.findById(id);
        return ResponseEntity.status(200).body(response);
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an instructor", description = "Delete an instructor from the database by their ID")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        instructorApplicationService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update an existing instructor", description = "Update the details of an existing instructor by their ID")
    public ResponseEntity<InstructorResponseDto> update(@PathVariable("id") Integer id, @RequestBody @Valid InstructorRequestDto dto){
        InstructorResponseDto response = instructorApplicationService.update(dto, id);
        return ResponseEntity.status(200).body(response);
    }
}
