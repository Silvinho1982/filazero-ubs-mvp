package com.filazero.ubs.service;
import com.filazero.ubs.dto.*;
import com.filazero.ubs.model.Project;
import com.filazero.ubs.repository.*;
import com.filazero.ubs.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class ProjectService {
    private final ProjectRepository projectRepo; private final ProfileRepository profileRepo; private final TechnologyRepository technologyRepo;
    public ProjectService(ProjectRepository projectRepo, ProfileRepository profileRepo, TechnologyRepository technologyRepo) {
        this.projectRepo = projectRepo; this.profileRepo = profileRepo; this.technologyRepo = technologyRepo;
    }
    public ProjectResponse create(ProjectRequest req) {
        var profile = profileRepo.findById(req.profileId()).orElseThrow(() -> new ResourceNotFoundException("Perfil não encontrado: " + req.profileId()));
        Project p = new Project(); p.setTitle(req.title()); p.setDescription(req.description()); p.setRepositoryUrl(req.repositoryUrl()); p.setProfile(profile);
        if (req.technologyIds() != null) p.getTechnologies().addAll(technologyRepo.findAllById(req.technologyIds()));
        p = projectRepo.save(p); return toResponse(p);
    }
    public List<ProjectResponse> list() { return projectRepo.findAll().stream().map(this::toResponse).toList(); }
    private ProjectResponse toResponse(Project p) {
        Set<TechnologyResponse> technologies = p.getTechnologies().stream().map(t -> new TechnologyResponse(t.getId(), t.getName(), t.getCategory())).collect(java.util.stream.Collectors.toSet());
        return new ProjectResponse(p.getId(), p.getTitle(), p.getDescription(), p.getRepositoryUrl(), p.getProfile().getId(), technologies);
    }
}
