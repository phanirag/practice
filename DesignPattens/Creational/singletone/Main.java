package DesignPattens.Creational.singletone;

public class Main {
    public static void main(String[] args) {
        LazyInitializedSingleton l1 = LazyInitializedSingleton.getInstance("test1");
        LazyInitializedSingleton l2 = LazyInitializedSingleton.getInstance("test2");
        LazyInitializedSingleton l3 = LazyInitializedSingleton.getInstance("test3");
        System.out.println(l1.hashCode());
        System.out.println(l2.hashCode());
        System.out.println(l3.hashCode());
    }
}
