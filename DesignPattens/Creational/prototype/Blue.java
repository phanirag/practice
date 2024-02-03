package DesignPattens.Creational.prototype;

public class Blue implements Prototype {

    public void color() {
        System.out.println("Blue");
    }

    @Override
    public Prototype clone() {
        return new Blue();
    }

}
