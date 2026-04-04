package com.herbert.SingletonPattern;

public class DCL2 {
    private static volatile DCL2 INSTANCE;
    private DCL2() {

    }

    public static DCL2 GetInstance() {
        if (INSTANCE == null) {
            synchronized (DCL2.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DCL2();
                }
            }
        }
        return INSTANCE;
    }
}
