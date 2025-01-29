package com.example.walletservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.UUID;

/**
 * Сущность "Кошелек".
 */
@Entity
@Data
public class Wallet {
    /**
     * ИД кошелька.
     */
    @Id
    private UUID id;

    /**
     * Баланс кошелька.
     */
    private long balance;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
