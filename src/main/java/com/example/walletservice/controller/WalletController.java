package com.example.walletservice.controller;

import com.example.walletservice.dto.WalletRequest;
import com.example.walletservice.model.Wallet;
import com.example.walletservice.service.WalletService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wallets")
@RequiredArgsConstructor
@Slf4j
public class WalletController {
    private final WalletService walletService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> updateWallet(@RequestBody WalletRequest request) {
        walletService.updateWallet(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{walletId}")
    public ResponseEntity<Long> getWalletBalance(@PathVariable UUID walletId) {
        return ResponseEntity.ok(walletService.getWalletBalance(walletId));
    }
}
