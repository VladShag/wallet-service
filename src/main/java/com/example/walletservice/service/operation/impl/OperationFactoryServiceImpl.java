package com.example.walletservice.service.operation.impl;

import com.example.walletservice.enums.OperationType;
import com.example.walletservice.exception.InvalidOperationTypeException;
import com.example.walletservice.service.operation.OperationFactoryService;
import com.example.walletservice.service.operation.WalletOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Реализация {@link OperationFactoryService}.
 */
@Component
public class OperationFactoryServiceImpl implements OperationFactoryService {
    private final Map<OperationType, WalletOperation> map = new HashMap<>();

    public OperationFactoryServiceImpl(List<WalletOperation> handlers) {
        for (WalletOperation handler : handlers) {
            map.put(handler.getOperationType(), handler);
        }
    }

    @Override
    public WalletOperation findHandler(OperationType operationType) {
        WalletOperation walletOperation = map.get(operationType);
        if (walletOperation == null) {
            throw new InvalidOperationTypeException("Не найдено обработчика для операции: " + operationType);
        }
        return walletOperation;
    }
}
