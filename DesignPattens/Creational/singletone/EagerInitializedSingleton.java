package DesignPattens.Creational.singletone;

public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {
    }

    public void hello() {
        System.out.println("Hello");
    }

    public static synchronized EagerInitializedSingleton getInstance() {
        return instance;
    }

}
