package com.example.auth.controllers;

import com.example.auth.domain.discipline.Discipline;
import com.example.auth.domain.discipline.DisciplineRequestDTO;
import com.example.auth.domain.discipline.DisciplineResponseDTO;
import com.example.auth.services.DisciplineService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController()
@RequestMapping("discipline")
public class DisciplineController {

    @Autowired
    DisciplineService service;

    @PostMapping
    public ResponseEntity<DisciplineResponseDTO> postDiscipline(@RequestBody @Valid DisciplineRequestDTO body) {
        Discipline newDiscipline = new Discipline(body);

        this.service.addDiscipline(newDiscipline);

        return new ResponseEntity<>(new DisciplineResponseDTO(newDiscipline), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DisciplineResponseDTO>> getAllDisciplines() {
        List<DisciplineResponseDTO> disciplineList = this.service.findAllDisciplines().stream()
                .map(DisciplineResponseDTO::new)
                .toList();

        return ResponseEntity.ok(disciplineList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplineResponseDTO> getDisciplineById(@PathVariable("id") String id) {
        Discipline discipline = this.service.findDisciplineById(id);

        return new ResponseEntity<>(new DisciplineResponseDTO(discipline), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<DisciplineResponseDTO> updateDiscipline(@PathVariable String id,
            @RequestBody @Valid DisciplineRequestDTO body) {
        Discipline discipline = this.service.updateDiscipline(id, body);

        return new ResponseEntity<>(new DisciplineResponseDTO(discipline), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DisciplineResponseDTO> deleteDiscipline(@PathVariable String id) {
        this.service.deleteDiscipline(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
