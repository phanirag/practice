package Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import Streams.models.Employe;
import Streams.models.Notes;

public class NthHighestSalary {

    public static void main(String[] args) {
        // Map map = new HashMap<String , Integer>();
        // IntStream.rangeClosed(0, 10).forEach(i -> map.put("tesst"+i, i));
//        getNthSalaryMap(2, map);
        // List list = new ArrayList();

//        IntStream.rangeClosed(0, 10).forEach(i -> list.add((int)(Math.random()* 50 + 1)));
        // list.addAll(Arrays.asList(1,2,33,44,44,44,11,1,11));
//        getNthSalaryList(0, list);
//        getMaxAndMinValue(list);
//        getNthSalaryWithDuplicates(0,list);
convertAndSort();
    }


    public static void getNthSalaryMap(Integer num, Map<String, Integer> map) {
        Map.Entry<String, Integer> stringIntegerEntry = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList().get(num);
        System.out.println(stringIntegerEntry);
    }

    public static void getNthSalaryList(Integer num, List<Integer> list) {
        System.out.println(list);
        Integer i = list.stream().sorted(Comparator.reverseOrder()).distinct().toList().get(1);
        System.out.println(i);
    }

    public static void getNthSalaryWithDuplicates(Integer num, List<Integer> list) {
        System.out.println(
                list.stream().min(Comparator.comparing(Integer::valueOf)).get()
        );
    }

    public static void getNthValueofDepartmentandSalaryOfCustomer() {
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

    public static void getNthValueofDepartmentandSalaryOfCustomer1() {
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


    //How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
    public static void convertAndSort() {
    List<Notes> noteLst = new ArrayList<>();
    noteLst.add(new Notes(1, "note1", 11));
    noteLst.add(new Notes(2, "note2", 22));
    noteLst.add(new Notes(3, "note3", 33));
    noteLst.add(new Notes(4, "note4", 44));
    noteLst.add(new Notes(5, "note5", 55));

    noteLst.add(new Notes(6, "note4", 66));


    Map<String, Integer> notesRecords = noteLst.stream()
                                            .sorted(Comparator
                                            .comparing(Notes::getVal)
                                            .reversed()) // sorting is based on TagId 55,44,33,22,11
                                            .collect(Collectors.toMap
                                            (Notes::getName, Notes::getId,
                                            (oldValue, newValue) -> oldValue,LinkedHashMap::new));
        System.out.println("Notes : " + notesRecords);
    }
}
