package com.filazero.ubs.controller;
import com.filazero.ubs.dto.*;
import com.filazero.ubs.service.ProfileService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/profiles")
public class ProfileController {
    private final ProfileService service; public ProfileController(ProfileService service){this.service=service;}
    @PostMapping public ResponseEntity<ProfileResponse> create(@Valid @RequestBody ProfileRequest req){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(req));}
    @GetMapping("/{id}") public ProfileResponse get(@PathVariable Long id){return service.get(id);}
}
