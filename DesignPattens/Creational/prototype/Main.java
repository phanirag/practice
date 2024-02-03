package DesignPattens.Creational.prototype;

public class Main {
    public static void main(String[] args) {
        Black b = new Black();
        b.color();
        System.out.println(b.hashCode());
        Black b1 = (Black) b.clone();
        b1.color();
        System.out.println(b1.hashCode());
    }
}
