package com.example.walletservice.exception;

/**
 * Ошибка, возникающая при недостатке баланса.
 */
public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}