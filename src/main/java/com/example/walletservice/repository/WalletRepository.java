package com.example.walletservice.repository;

import com.example.walletservice.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Репозиторий для работы с таблицей wallet.
 */
public interface WalletRepository extends JpaRepository<Wallet, UUID> {
}
