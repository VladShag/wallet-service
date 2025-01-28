package com.example.walletservice.service;

import com.example.walletservice.dto.WalletRequest;

import java.util.UUID;

public interface WalletService {

    void updateWallet(WalletRequest walletRequest);

    Long getWalletBalance(UUID walletId);
}
