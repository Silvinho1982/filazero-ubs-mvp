package com.filazero.ubs.repository;
import com.filazero.ubs.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByCpf(String cpf);
}
