package com.filazero.ubs.service;
import com.filazero.ubs.dto.*;
import com.filazero.ubs.model.Appointment;
import com.filazero.ubs.repository.*;
import com.filazero.ubs.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepo; private final UserAccountRepository userRepo; private final UbsRepository ubsRepo; private final SpecialtyRepository specialtyRepo;
    public AppointmentService(AppointmentRepository appointmentRepo, UserAccountRepository userRepo, UbsRepository ubsRepo, SpecialtyRepository specialtyRepo) { this.appointmentRepo=appointmentRepo;this.userRepo=userRepo;this.ubsRepo=ubsRepo;this.specialtyRepo=specialtyRepo; }
    public AppointmentResponse create(AppointmentRequest req) {
        var user = userRepo.findById(req.userId()).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
        var ubs = ubsRepo.findById(req.ubsId()).orElseThrow(() -> new ResourceNotFoundException("UBS não encontrada."));
        var specialty = specialtyRepo.findById(req.specialtyId()).orElseThrow(() -> new ResourceNotFoundException("Especialidade não encontrada."));
        Appointment a = new Appointment(); a.setUser(user); a.setUbs(ubs); a.setSpecialty(specialty); a.setDate(req.date()); a.setTime(req.time()); a.setStatus("CONFIRMADO");
        a = appointmentRepo.save(a);
        return new AppointmentResponse(a.getId(), ubs.getName(), specialty.getName(), a.getDate(), a.getTime(), a.getStatus());
    }
    public List<AppointmentResponse> listByUser(Long userId) { return appointmentRepo.findByUserIdOrderByDateAscTimeAsc(userId).stream().map(a -> new AppointmentResponse(a.getId(), a.getUbs().getName(), a.getSpecialty().getName(), a.getDate(), a.getTime(), a.getStatus())).toList(); }
}
