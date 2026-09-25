package com.filazero.ubs.controller;
import com.filazero.ubs.dto.*; import com.filazero.ubs.service.TechnologyService; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/technologies") public class TechnologyController {
    private final TechnologyService service; public TechnologyController(TechnologyService service){this.service=service;}
    @PostMapping public ResponseEntity<TechnologyResponse> create(@Valid @RequestBody TechnologyRequest req){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(req));}
    @GetMapping public List<TechnologyResponse> list(){return service.list();}
}
