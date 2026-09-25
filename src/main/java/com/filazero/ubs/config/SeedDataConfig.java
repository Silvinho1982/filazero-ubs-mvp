package com.filazero.ubs.config;

import com.filazero.ubs.model.Specialty;
import com.filazero.ubs.model.Ubs;
import com.filazero.ubs.model.UserAccount;
import com.filazero.ubs.repository.SpecialtyRepository;
import com.filazero.ubs.repository.UbsRepository;
import com.filazero.ubs.repository.UserAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeedDataConfig {
    @Bean
    CommandLineRunner seed(UbsRepository ubsRepo, SpecialtyRepository specialtyRepo, UserAccountRepository userRepo) {
        return args -> {
            if (ubsRepo.count() == 0) {
                for (int i = 1; i <= 33; i++) {
                    Ubs u = new Ubs();
                    u.setName(String.format("UBS %02d - Unidade Básica de Saúde", i));
                    u.setAddress(String.format("Rua da Saúde, %d - Município de Piripiri/PI", 100 + i));
                    ubsRepo.save(u);
                }
            }
            if (specialtyRepo.count() == 0) {
                for (String name : new String[]{"Clínico Geral", "Enfermagem", "Pediatria", "Ginecologia", "Odontologia"}) {
                    Specialty s = new Specialty(); s.setName(name); specialtyRepo.save(s);
                }
            }
            if (userRepo.count() == 0) {
                UserAccount u = new UserAccount();
                u.setName("Usuário Demonstração"); u.setCpf("12345678900"); u.setEmail("demo@filazero.local"); u.setPhone("86999999999"); u.setPassword("123456");
                userRepo.save(u);
            }
        };
    }
}
