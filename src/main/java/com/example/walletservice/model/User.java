package com.example.walletservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

/**
 * Сущность "Пользователь".
 */
@Entity
@Table(name = "users")
@Data
public class User {
    /**
     * ИД пользователя
     */
    @Id
    private UUID id;

    /**
     * Имя пользователя
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * Пароль
     */
    @Column(nullable = false)
    private String password;

    /**
     * Роли пользователя
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}