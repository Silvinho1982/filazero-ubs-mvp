package com.filazero.ubs.controller;
import com.filazero.ubs.dto.*; import com.filazero.ubs.service.AuthService; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/auth") public class AuthController {
    private final AuthService service; public AuthController(AuthService service){this.service=service;}
    @PostMapping("/login") public LoginResponse login(@Valid @RequestBody LoginRequest req){return service.login(req);}
    @PostMapping("/register") public ResponseEntity<LoginResponse> register(@Valid @RequestBody RegisterRequest req){return ResponseEntity.status(HttpStatus.CREATED).body(service.register(req));}
    @PostMapping("/recovery") public java.util.Map<String,String> recovery(@Valid @RequestBody RecoveryRequest req){return java.util.Map.of("message", "Instruções de recuperação enviadas pelo canal informado.");}
}
