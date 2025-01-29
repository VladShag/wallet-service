package com.example.walletservice.dto;

import lombok.Data;

import java.util.UUID;

/**
 * ДТО запроста на обновление баланса.
 */
@Data
public class WalletRequestDto {
    /**
     * ИД кошелька
     */
    private UUID walletId;

    /**
     * Тип операции
     */
    private String operationType;

    /**
     * Сумма на которую изменяется баланс
     */
    private Long amount;
}
