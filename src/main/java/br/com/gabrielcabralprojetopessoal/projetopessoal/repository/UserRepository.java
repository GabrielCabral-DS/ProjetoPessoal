package br.com.gabrielcabralprojetopessoal.projetopessoal.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.gabrielcabralprojetopessoal.projetopessoal.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    // Buscar por username e email

    User findByUserName(String userName);

    User findByEmail(String email);
}
