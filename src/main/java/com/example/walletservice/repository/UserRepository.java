package com.example.walletservice.repository;

import com.example.walletservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Репозиторий для работы с таблицей user.
 */
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}
