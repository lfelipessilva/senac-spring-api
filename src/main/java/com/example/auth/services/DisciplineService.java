package com.example.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auth.domain.discipline.Discipline;
import com.example.auth.domain.discipline.DisciplineRequestDTO;
import com.example.auth.exceptions.NotFoundException;
import com.example.auth.repositories.DisciplineRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class DisciplineService {
  private final DisciplineRepository disciplineRepository;

  @Autowired
  public DisciplineService(DisciplineRepository DisciplineRepository) {
    this.disciplineRepository = DisciplineRepository;
  }

  public Discipline addDiscipline(Discipline Discipline) {
    return disciplineRepository.save(Discipline);
  }

  public List<Discipline> findAllDisciplines() {
    return disciplineRepository.findAll();
  }

  public Discipline updateDiscipline(String id, DisciplineRequestDTO discipline) {
    disciplineRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Discipline not found"));

    Discipline disciplineToSave = new Discipline(id, discipline.name(), discipline.description(),
        discipline.workload());

    return disciplineRepository.save(disciplineToSave);
  }

  public Discipline findDisciplineById(String id) {
    return disciplineRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Discipline not found"));
  }

  public void deleteDiscipline(String id) {
    disciplineRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Discipline not found"));

    disciplineRepository.deleteById(id);
  }
}
