package com.filazero.ubs.controller;
import com.filazero.ubs.dto.*; import com.filazero.ubs.service.ProjectService; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/projects") public class ProjectController {
    private final ProjectService service; public ProjectController(ProjectService service){this.service=service;}
    @PostMapping public ResponseEntity<ProjectResponse> create(@Valid @RequestBody ProjectRequest req){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(req));}
    @GetMapping public List<ProjectResponse> list(){return service.list();}
}
