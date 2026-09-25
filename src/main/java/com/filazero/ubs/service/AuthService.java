package com.filazero.ubs.service;
import com.filazero.ubs.dto.*;
import com.filazero.ubs.model.UserAccount;
import com.filazero.ubs.repository.UserAccountRepository;
import org.springframework.stereotype.Service;
@Service
public class AuthService {
    private final UserAccountRepository repo;
    public AuthService(UserAccountRepository repo) { this.repo = repo; }
    public LoginResponse login(LoginRequest req) {
        UserAccount u = repo.findByCpf(req.cpf()).orElseThrow(() -> new IllegalArgumentException("CPF ou senha inválidos."));
        if (!u.getPassword().equals(req.password())) throw new IllegalArgumentException("CPF ou senha inválidos.");
        return new LoginResponse(u.getId(), u.getName(), u.getCpf());
    }
    public LoginResponse register(RegisterRequest req) {
        if (repo.findByCpf(req.cpf()).isPresent()) throw new IllegalArgumentException("CPF já cadastrado.");
        UserAccount u = new UserAccount(); u.setName(req.name()); u.setCpf(req.cpf()); u.setEmail(req.email()); u.setPhone(req.phone()); u.setPassword(req.password());
        u = repo.save(u); return new LoginResponse(u.getId(), u.getName(), u.getCpf());
    }
}
