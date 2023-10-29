package com.example.auth.domain.discipline;

public record DisciplineResponseDTO(String id, String name, String description, Integer workload) {
    public DisciplineResponseDTO(Discipline discipline) {
        this(discipline.getId(), discipline.getName(), discipline.getDescription(), discipline.getWorkload());
    }
}
