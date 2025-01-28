package com.example.walletservice.service.operation.impl;

import com.example.walletservice.enums.OperationType;
import com.example.walletservice.model.Wallet;
import com.example.walletservice.service.operation.WalletOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepositOperation implements WalletOperation {

    @Override
    public OperationType getOperationType() {
        return OperationType.DEPOSIT;
    }

    @Override
    public void execute(Wallet wallet, long amount) {
        log.info("Происходит пополнение кошелька с Id {} на сумму {}", wallet.getId(), amount);
        wallet.setBalance(wallet.getBalance() + amount);
    }
}
