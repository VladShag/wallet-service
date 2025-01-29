package com.example.walletservice.service.operation.impl;

import com.example.walletservice.enums.OperationType;
import com.example.walletservice.exception.InsufficientFundsException;
import com.example.walletservice.model.Wallet;
import com.example.walletservice.service.operation.WalletOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Реализация {@link WalletOperation} для операции снятия.
 */
@Service
@Slf4j
public class WithdrawOperation implements WalletOperation {

    @Override
    public OperationType getOperationType() {
        return OperationType.WITHDRAW;
    }

    @Override
    public void execute(Wallet wallet, long amount) {
        log.info("Происходит списание с кошелька с Id {} на сумму {}", wallet.getId(), amount);
        if (wallet.getBalance() < amount) {
            throw new InsufficientFundsException("Недостаточно средст для снятия");
        }
        wallet.setBalance(wallet.getBalance() - amount);
    }
}