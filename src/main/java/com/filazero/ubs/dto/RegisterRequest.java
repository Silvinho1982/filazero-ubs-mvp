package com.filazero.ubs.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public record RegisterRequest(@NotBlank String name, @NotBlank String cpf, @NotBlank @Email String email,
                              @NotBlank String phone, @NotBlank String password) {}
