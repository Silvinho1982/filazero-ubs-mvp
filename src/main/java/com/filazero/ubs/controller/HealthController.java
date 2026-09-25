package com.filazero.ubs.controller;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api") public class HealthController {
    @GetMapping("/health") public java.util.Map<String,String> health(){return java.util.Map.of("status","UP","app","Fila Zero UBS MVP");}
}
