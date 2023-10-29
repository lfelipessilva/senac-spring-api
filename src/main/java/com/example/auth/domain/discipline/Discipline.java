package com.example.auth.domain.discipline;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "discipline")
@Entity(name = "discipline")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String description;

    private Integer workload;

    public Discipline(DisciplineRequestDTO data) {
        this.name = data.name();
        this.description = data.description();
        this.workload = data.workload();
    }
}