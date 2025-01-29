package com.example.walletservice.exception;

/**
 * Ошибка, возникающая при не найденном кошельке.
 */
public class WalletNotFoundException extends RuntimeException {
    public WalletNotFoundException(String message) {
        super(message);
    }
}
