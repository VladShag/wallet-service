package com.example.walletservice.repository;

import com.example.walletservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Репозиторий для работы с таблицей role.
 */
public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByName(String name);
}
