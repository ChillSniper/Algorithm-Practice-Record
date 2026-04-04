package com.herbert.SingletonPattern;

public class LazyLoad {
    private static LazyLoad Instance;
    private LazyLoad() {

    }
    public static synchronized  LazyLoad getInstance() {
        if (Instance == null) {
            Instance = new LazyLoad();
        }
        return Instance;
    }
}
