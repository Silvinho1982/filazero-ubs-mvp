package com.filazero.ubs.service;
import com.filazero.ubs.dto.*;
import com.filazero.ubs.model.Profile;
import com.filazero.ubs.repository.ProfileRepository;
import com.filazero.ubs.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class ProfileService {
    private final ProfileRepository repo;
    public ProfileService(ProfileRepository repo) { this.repo = repo; }
    public ProfileResponse create(ProfileRequest req) {
        Profile p = new Profile(); p.setName(req.name()); p.setEmail(req.email()); p.setBio(req.bio());
        p = repo.save(p); return new ProfileResponse(p.getId(), p.getName(), p.getEmail(), p.getBio());
    }
    public ProfileResponse get(Long id) {
        Profile p = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrado: " + id));
        return new ProfileResponse(p.getId(), p.getName(), p.getEmail(), p.getBio());
    }
}
