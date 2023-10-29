package com.example.auth.controllers;

import com.example.auth.domain.discipline.Discipline;
import com.example.auth.domain.discipline.DisciplineRequestDTO;
import com.example.auth.domain.discipline.DisciplineResponseDTO;
import com.example.auth.repositories.DisciplineRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("discipline")
public class DisciplineController {

    @Autowired
    DisciplineRepository repository;

    @PostMapping
    public ResponseEntity postDiscipline(@RequestBody @Valid DisciplineRequestDTO body){
        Discipline newDiscipline = new Discipline(body);

        this.repository.save(newDiscipline);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getAllDisciplines(){
        List<DisciplineResponseDTO> disciplineList = this.repository.findAll().stream().map(DisciplineResponseDTO::new).toList();

        return ResponseEntity.ok(disciplineList);
    }
}
