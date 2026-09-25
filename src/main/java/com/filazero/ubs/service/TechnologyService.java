package com.filazero.ubs.service;
import com.filazero.ubs.dto.*;
import com.filazero.ubs.model.Technology;
import com.filazero.ubs.repository.TechnologyRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TechnologyService {
    private final TechnologyRepository repo;
    public TechnologyService(TechnologyRepository repo) { this.repo = repo; }
    public TechnologyResponse create(TechnologyRequest req) {
        Technology t = new Technology(); t.setName(req.name()); t.setCategory(req.category()); t = repo.save(t);
        return new TechnologyResponse(t.getId(), t.getName(), t.getCategory());
    }
    public List<TechnologyResponse> list() { return repo.findAll().stream().map(t -> new TechnologyResponse(t.getId(), t.getName(), t.getCategory())).toList(); }
}
