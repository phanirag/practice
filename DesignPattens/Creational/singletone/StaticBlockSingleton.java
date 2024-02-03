package DesignPattens.Creational.singletone;

public class StaticBlockSingleton {
    private static StaticBlockSingleton instace;

    private StaticBlockSingleton() {
    }

    static {
        try {
            instace = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Error while creating singletone");
        }
    }

    public static StaticBlockSingleton getInstace() {
        return instace;
    }
}
