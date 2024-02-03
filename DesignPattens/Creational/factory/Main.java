package DesignPattens.Creational.factory;

public class Main {
    public static void main(String[] args) {
        Company c = CompanyFactory.getCompany("Dell");
        System.out.println(c.getCompanyName());
    }
}
