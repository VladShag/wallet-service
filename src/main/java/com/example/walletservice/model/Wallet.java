package com.example.walletservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Wallet {
    @Id
    private UUID id;
    private long balance;
}
