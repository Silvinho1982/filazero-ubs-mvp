package com.filazero.ubs.controller;
import com.filazero.ubs.dto.*; import com.filazero.ubs.repository.*; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/specialties") public class SpecialtyController {
    private final SpecialtyRepository repo; public SpecialtyController(SpecialtyRepository repo){this.repo=repo;}
    @GetMapping public List<SpecialtyResponse> list(){return repo.findAll().stream().map(s -> new SpecialtyResponse(s.getId(),s.getName())).toList();}
}
