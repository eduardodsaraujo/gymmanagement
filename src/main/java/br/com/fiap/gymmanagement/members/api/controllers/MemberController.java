package br.com.fiap.gymmanagement.members.api.controllers;


import br.com.fiap.gymmanagement.instructors.application.services.dto.InstructorRequestDto;
import br.com.fiap.gymmanagement.instructors.application.services.dto.InstructorResponseDto;
import br.com.fiap.gymmanagement.members.application.services.MemberApplicationService;
import br.com.fiap.gymmanagement.members.application.services.dto.MemberRequestDto;
import br.com.fiap.gymmanagement.members.application.services.dto.MemberResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Members")
@RequestMapping(value = "/api/members")
public class MemberController {

    private MemberApplicationService memberApplicationService;


    @PostMapping()
    @Operation(summary = "Add a new member", description = "Create a new member and store it in the database")
    public ResponseEntity<MemberResponseDto> create
            (@RequestBody @Valid MemberRequestDto dto) {

        MemberResponseDto response = memberApplicationService.create(dto);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping()
    @Operation(summary = "Get all members", description = "Retrieve a list of all available members")
    public ResponseEntity<List<MemberResponseDto>> findAll(){
        List<MemberResponseDto> response = memberApplicationService.findAll();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an member by ID", description = "Retrieve a specific member by their unique ID")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable("id" ) Integer id){
        MemberResponseDto response = memberApplicationService.findById(id);
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an member", description = "Delete an member from the database by their ID")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        memberApplicationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing member", description = "Update the details of an existing member by their ID")
    public ResponseEntity<MemberResponseDto> update(@PathVariable("id") Integer id, @RequestBody @Valid MemberRequestDto dto){
        MemberResponseDto response = memberApplicationService.update(dto, id);
        return ResponseEntity.status(200).body(response);
    }
}
