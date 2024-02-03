package DesignPattens.Creational.singletone;

public class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {
    }

    public static synchronized LazyInitializedSingleton getInstance(String val) {
        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}