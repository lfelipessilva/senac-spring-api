package com.example.auth.repositories;

import com.example.auth.domain.discipline.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, String> {
}
