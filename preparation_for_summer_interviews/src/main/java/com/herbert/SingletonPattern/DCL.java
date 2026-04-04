package com.herbert.SingletonPattern;

public class DCL {
    private static volatile DCL Instance;
    private DCL() {

    }
    public static DCL getInstance() {
        if (Instance == null) {
            synchronized (DCL.class) {
                if (Instance == null) {
                    Instance = new DCL();
                }
            }
        }
        return Instance;
    }
}
