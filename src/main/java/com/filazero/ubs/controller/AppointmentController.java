package com.filazero.ubs.controller;
import com.filazero.ubs.dto.*; import com.filazero.ubs.service.AppointmentService; import jakarta.validation.Valid; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/appointments") public class AppointmentController {
    private final AppointmentService service; public AppointmentController(AppointmentService service){this.service=service;}
    @PostMapping public ResponseEntity<AppointmentResponse> create(@Valid @RequestBody AppointmentRequest req){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(req));}
    @GetMapping("/user/{userId}") public List<AppointmentResponse> list(@PathVariable Long userId){return service.listByUser(userId);}
}
