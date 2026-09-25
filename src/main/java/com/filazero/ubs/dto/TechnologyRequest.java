package com.filazero.ubs.dto;
import jakarta.validation.constraints.NotBlank;
public record TechnologyRequest(@NotBlank String name, String category) {}
