package DesignPattens.Creational.factory;

public class CompanyFactory {
    public static Company getCompany(String val) {
        if (val.equals("HP"))
            return new HP();
        else if (val.equals("Dell"))
            return new Dell();
        return null;
    }
}
