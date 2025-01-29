package com.example.walletservice.exception;

/**
 * Ошибка, возникающая при указании неподдерживаемой операции.
 */
public class InvalidOperationTypeException extends RuntimeException {
    public InvalidOperationTypeException(String message) {
        super(message);
    }
}
