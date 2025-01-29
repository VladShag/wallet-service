package com.example.walletservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

/**
 * Сущность "Роль".
 */
@Entity
@Table(name = "roles")
@Data
public class Role {
    /**
     * ИД роли
     */
    @Id
    private UUID id;

    /**
     * Название роли
     */
    @Column(nullable = false, unique = true)
    private String name;
}
