package com.filazero.ubs.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.Set;
public record ProjectRequest(@NotBlank String title, @NotBlank String description,
                             @Pattern(regexp = "^$|https?://.*", message = "repositoryUrl deve ser uma URL válida") String repositoryUrl,
                             @NotNull Long profileId, Set<Long> technologyIds) {}
