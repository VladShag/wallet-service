package com.example.walletservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class WalletRequest {
    private UUID walletId;
    private String operationType;
    private Long amount;
}
