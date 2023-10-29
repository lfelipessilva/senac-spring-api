package com.example.auth.domain.discipline;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DisciplineRequestDTO(
    @NotBlank String name,
    @NotBlank String description,
    @NotNull Integer workload) {
}
