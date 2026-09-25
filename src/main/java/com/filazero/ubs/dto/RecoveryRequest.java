package com.filazero.ubs.dto;
import jakarta.validation.constraints.NotBlank;
public record RecoveryRequest(@NotBlank String contact, @NotBlank String channel) {}
