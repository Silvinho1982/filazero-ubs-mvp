package com.filazero.ubs.dto;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
public record AppointmentRequest(@NotNull Long userId, @NotNull Long ubsId, @NotNull Long specialtyId,
                                 @NotNull LocalDate date, @NotNull LocalTime time) {}
