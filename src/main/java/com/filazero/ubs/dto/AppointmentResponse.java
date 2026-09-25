package com.filazero.ubs.dto;
import java.time.LocalDate;
import java.time.LocalTime;
public record AppointmentResponse(Long id, String ubs, String specialty, LocalDate date, LocalTime time, String status) {}
