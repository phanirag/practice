package Streams;

import Streams.models.Employe;

import java.util.*;
import java.util.stream.Collectors;

public class SteamsTest {
    public static void main(String[] args) {
        List<Employe> employes = Employe.getEmployees();

        Map.Entry<String, List<Double>> stringListEntry = employes.stream()
                .sorted(Comparator.comparing(Employe::getSalary).reversed())
                .collect(Collectors.groupingBy(
                        Employe::getDepartment,
                        LinkedHashMap::new,
                        Collectors.mapping(Employe::getSalary, Collectors.toList())
                )).entrySet().stream().toList().get(0);

        System.out.println(stringListEntry);
    }
}