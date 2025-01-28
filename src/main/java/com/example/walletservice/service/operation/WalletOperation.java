package com.example.walletservice.service.operation;

import com.example.walletservice.enums.OperationType;
import com.example.walletservice.model.Wallet;

public interface WalletOperation {

    OperationType getOperationType();

    void execute(Wallet wallet, long amount);
}
