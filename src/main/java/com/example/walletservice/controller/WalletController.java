package com.example.walletservice.controller;

import com.example.walletservice.dto.WalletRequestDto;
import com.example.walletservice.model.Wallet;
import com.example.walletservice.service.WalletService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Контроллер для работы с сущностью {@link Wallet}.
 */
@RestController
@RequestMapping("/api/v1/wallets")
@RequiredArgsConstructor
@Slf4j
public class WalletController {
    private final WalletService walletService;

    /**
     * Обновить баланс кошелька с помощью {@link WalletRequestDto}.
     *
     * @param request дто с запросом на обновление
     */
    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void updateWallet(@RequestBody WalletRequestDto request) {
        walletService.updateWallet(request);
    }

    /**
     * Получить баланс кошелька по его ID.
     *
     * @param walletId ИД кошелька
     * @return Баланс кошелька в виде {@link Long}
     */
    @GetMapping("/{walletId}")
    public Long getWalletBalance(@PathVariable UUID walletId) {
        return walletService.getWalletBalance(walletId);
    }
}
