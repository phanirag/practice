package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntSteam {
    public static void main(String[] args) {

        int[] val = {1,44,2,1,22,44,66,66,4,44,5,77,33,22};

//        System.out.println(getSortedList(val));
//        System.out.println(getSortedListWithoutDuplicates(val));
//        System.out.println(getValuesofArrays(val));
//        System.out.println(getNthHigheshtNumber(val, 0));
//        getMinAndMaxofArrays(val);
//        getElementStartWith(val, 7);
        parllelStreams();

    }

    public static List<Integer> getSortedList(int[] val) {
        return Arrays.stream(val).boxed().sorted(Comparator.reverseOrder()).toList();
    }

    public static List<Integer> getSortedListWithoutDuplicates(int[] val) {
        return Arrays.stream(val).boxed().sorted(Comparator.reverseOrder()).distinct().toList();
    }
    public static Map<Integer, List<Integer>> getValuesofArrays(int[] val) {
         return Arrays.stream(val).boxed().collect(Collectors.groupingBy(s -> s));
    }

    public static void getMinAndMaxofArrays(int[] val) {
        System.out.println("Min val: " + Arrays.stream(val).boxed().min(Comparator.comparing(Integer::valueOf)).get());
        System.out.println("Max val: " + Arrays.stream(val).boxed().max(Comparator.comparing(Integer::valueOf)).get());
    }

    public static Integer getNthHigheshtNumber(int[] val, Integer num) {
        return Arrays.stream(val).boxed().sorted(Comparator.reverseOrder()).toList().get(num);
    }

    public static void getElementStartWith(int[] val, int i) {
        List<Integer> list1 = Arrays.stream(val).boxed().filter(t -> t.toString().split("")[0].equals(Integer.valueOf(i).toString())).toList();
        System.out.println(list1);
    }

    public static void getEvenAndOddSum() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Integer evenSum = list.stream().filter(x -> x % 2 == 0).mapToInt(Integer::intValue).sum();
        Integer oddSum = list.stream().filter(x -> x % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println(evenSum);
        System.out.println(oddSum);
    }

    public static void parllelStreams() {
        List list = Arrays.asList(1,3,3,2,3,5,4,3);
        List l2 = list.parallelStream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(l2);
    }
}
