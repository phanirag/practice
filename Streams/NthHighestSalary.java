package Streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NthHighestSalary {

    public static void main(String[] args) {
        Map map = new HashMap<String , Integer>();
        IntStream.rangeClosed(0, 10).forEach(i -> map.put("tesst"+i, i));
//        getNthSalaryMap(2, map);
        List list = new ArrayList();

//        IntStream.rangeClosed(0, 10).forEach(i -> list.add((int)(Math.random()* 50 + 1)));
        list.addAll(Arrays.asList(1,2,33,44,44,44,11,1,11));
//        getNthSalaryList(0, list);
//        getMaxAndMinValue(list);
//        getNthSalaryWithDuplicates(0,list);
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
}
