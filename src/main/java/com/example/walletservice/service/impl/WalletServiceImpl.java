package com.example.walletservice.service.impl;

import com.example.walletservice.dto.WalletRequest;
import com.example.walletservice.enums.OperationType;
import com.example.walletservice.exception.InsufficientFundsException;
import com.example.walletservice.exception.InvalidOperationTypeException;
import com.example.walletservice.exception.WalletNotFoundException;
import com.example.walletservice.model.Wallet;
import com.example.walletservice.repository.WalletRepository;
import com.example.walletservice.service.WalletService;
import com.example.walletservice.service.operation.OperationFactoryService;
import com.example.walletservice.service.operation.WalletOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    private final OperationFactoryService operationFactory;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public synchronized void updateWallet(WalletRequest walletRequest) {
        log.info("Начинаем операцию {} для кошелька с UUID {}",
                walletRequest.getOperationType(), walletRequest.getWalletId());
        Wallet wallet = walletRepository.findById(walletRequest.getWalletId())
                .orElseThrow(() -> new WalletNotFoundException("Кошелек не найден!"));

        OperationType operationType = OperationType.getTypeFromNameOrElseThrow(walletRequest.getOperationType());
        Long amount = walletRequest.getAmount();

        WalletOperation walletOperation = operationFactory.findHandler(operationType);
        walletOperation.execute(wallet, amount);
        walletRepository.save(wallet);
    }

    @Override
    public Long getWalletBalance(UUID walletId) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(
                () -> new WalletNotFoundException("Кошелек не найден!"));
        return wallet.getBalance();
    }
}
