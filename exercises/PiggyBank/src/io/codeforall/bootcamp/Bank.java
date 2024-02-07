package io.codeforall.bootcamp;

public class Bank {

    public enum OperationType {
        DEPOSIT,
        PAYMENT
    }
    public static void GetOperationType() {
        for (OperationType getOperationType : OperationType.values()) {
            System.out.println(getOperationType);
        }
    }
}
