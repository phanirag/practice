package Streams.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Employe {

    public Employe(int id, String name, Double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    private String name;
    private Double salary;

    private String department;


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static List<Employe> getEmployees() {
        List<Employe> employes = new ArrayList<>(1000);
        IntStream.range(1, 1000).forEach(i -> employes.add(new Employe(i, "Test" + i, (double)i, "Dep" + i)));
        return employes;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + id +
                ", empName='" + name + '\'' +
                ", empDepartment='" + department + '\'' +
                ", empSalary=" + salary +
                '}';
    }
}
