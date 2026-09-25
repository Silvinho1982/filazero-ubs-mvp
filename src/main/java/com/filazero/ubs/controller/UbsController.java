package com.filazero.ubs.controller;
import com.filazero.ubs.dto.*; import com.filazero.ubs.repository.*; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/ubs") public class UbsController {
    private final UbsRepository repo; public UbsController(UbsRepository repo){this.repo=repo;}
    @GetMapping public List<UbsResponse> list(){return repo.findAll().stream().map(u -> new UbsResponse(u.getId(),u.getName(),u.getAddress())).toList();}
}
