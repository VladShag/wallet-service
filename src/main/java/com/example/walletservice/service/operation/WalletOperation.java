package com.example.walletservice.service.operation;

import com.example.walletservice.enums.OperationType;
import com.example.walletservice.model.Wallet;

/**
 * Интерфейс сервисов операций с кошельком.
 */
public interface WalletOperation {

    /**
     * Получить {@link OperationType} данного сервиса.
     *
     * @return тип операции конкретной реализации
     */
    OperationType getOperationType();

    /**
     * Выполнить операцию.
     *
     * @param wallet кошелек над который будет выполнена операция
     * @param amount сумма операции
     */
    void execute(Wallet wallet, long amount);
}
