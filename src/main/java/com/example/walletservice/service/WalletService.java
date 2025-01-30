package com.example.walletservice.service;

import com.example.walletservice.dto.WalletRequestDto;

import java.util.UUID;

/**
 * Сервис для работы с сущностью "Кошелек".
 */
public interface WalletService {

    /**
     * Обновить баланс кошелька с помощью {@link WalletRequestDto}.
     *
     * @param walletRequestDto дто с запросом на обновление
     */
    void updateWallet(WalletRequestDto walletRequestDto);

    /**
     * Получить баланс кошелька по его ID.
     *
     * @param walletId ИД кошелька
     * @return Баланс кошелька в виде {@link Long}
     */
    Long getWalletBalance(UUID walletId);

    /**
     * Получить ID владельца кошелька по ID кошелька.
     *
     * @param walletId ИД кошелька
     * @return {@link UUID} пользователя
     */
    UUID getWalletUserId(UUID walletId);
}
