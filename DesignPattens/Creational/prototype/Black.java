package DesignPattens.Creational.prototype;

public class Black implements Prototype {

    public void color() {
        System.out.println("Black");
    }

    @Override
    public Prototype clone() {
        return new Black();
    }

}
