package com.example.walletservice.service.operation;

import com.example.walletservice.enums.OperationType;

/**
 * Фабрика для выбора обработчика в зависимости от типа операции.
 */
public interface OperationFactoryService {

    /**
     * Найти нужный сервис по {@link OperationType}.
     *
     * @param operationType тип операции
     * @return {@link WalletOperation} реализация для нужной операции
     */
    WalletOperation findHandler(OperationType operationType);
}
