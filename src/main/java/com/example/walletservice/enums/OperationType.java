package com.example.walletservice.enums;

import com.example.walletservice.exception.InvalidOperationTypeException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum OperationType {

    DEPOSIT("DEPOSIT"),
    WITHDRAW("WITHDRAW");

    private final String operationName;

    public static OperationType getTypeFromNameOrElseThrow(String operationName) {
        return Arrays.stream(OperationType.values())
                .filter(elem -> elem.operationName.equals(operationName))
                .findFirst()
                .orElseThrow(() -> new InvalidOperationTypeException(
                        "Не найдена операция " + operationName));
    }
}
