package com.example.walletservice.model;

import jakarta.persistence.*;
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