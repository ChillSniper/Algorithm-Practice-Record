package com.herbert.SingletonPattern;

public class HungryLoad {
    private static final HungryLoad INSTANCE = new HungryLoad();

    private HungryLoad() {

    }

    public static HungryLoad getInstance() {
        return INSTANCE;
    }
}
