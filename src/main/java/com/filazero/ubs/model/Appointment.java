package com.filazero.ubs.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime time;
    @Column(nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private UserAccount user;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Ubs ubs;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Specialty specialty;

    public Long getId() { return id; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public UserAccount getUser() { return user; }
    public void setUser(UserAccount user) { this.user = user; }
    public Ubs getUbs() { return ubs; }
    public void setUbs(Ubs ubs) { this.ubs = ubs; }
    public Specialty getSpecialty() { return specialty; }
    public void setSpecialty(Specialty specialty) { this.specialty = specialty; }
}
