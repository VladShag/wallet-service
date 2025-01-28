package com.example.walletservice.service.operation;

import com.example.walletservice.enums.OperationType;

public interface OperationFactoryService {

    WalletOperation findHandler(OperationType operationType);
}
