package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringStream {
    public static void main(String[] args) {
        String vale = "The Is The Value Which need to test";
        // stringReverse(vale);


        // System.out.println(getValueOfString(vale));
        // System.out.println(getValueOfStringAndCount(vale));
        // System.out.println(getValueOfStringWithDuplicates(vale));
        // System.out.println(getValueOfStringWithUniqure(vale));
        // System.out.println(getValueOfStringWithUniqureGetOnlyFirstTwo(vale));
        // System.out.println(getValueOfStringWithUniqureGetOnlyFirstTwoAndSkipFirstElement(vale));
        // stringJoin(vale);

        // String[] vals = { "New", "test", "val", "testing"," val"};
        // System.out.println(findLaregestInString(vals));
        // ConcatTwoStingSteams();

    }

    public static void stringReverse(String val) {
        // String[] split = val.split("");
        // String result = "";
        // for(int i =split.length -1; i >= 0; i--) {
        //     result = result + split[i];
        // }

        String result = Arrays.stream(val.split("")).reduce("", (a, b) -> b + a);
        System.out.println(result);

    }

    public static String findLaregestInString(String[] vals) {
        return Arrays.stream(vals).reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
    }

    public static void stringJoin(String val) {
        StringJoiner j = new StringJoiner("-");
        String[] split = val.split("");
        for(int i = 0; i<= split.length-1 ; i++) {
            j.add(split[i]);
        }
        System.out.println(j);
    }
    public static Map<String, List<String>> getValueOfString(String val) {
        return Arrays.stream(val.split("")).collect(Collectors.groupingBy(s -> s));
    }

    public static Map<String, Long> getValueOfStringAndCount(String val) {
        return Arrays.stream(val.replace(" ", "").split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static List<String> getValueOfStringWithDuplicates(String val) {
        return Arrays.stream(val.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(s -> s.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getValueOfStringWithUniqure(String val) {
        return Arrays.stream(val.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(s -> s.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getValueOfStringWithUniqureGetOnlyFirstTwo(String val) {
        return Arrays.stream(val.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(s -> s.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList().stream().limit(2).toList();
    }

    public static List<String> getValueOfStringWithUniqureGetOnlyFirstTwoAndSkipFirstElement(String val) {
        return Arrays.stream(val.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(s -> s.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList().stream().skip(1).limit(2).toList();
    }

    public static void ConcatTwoStingSteams() {
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");
 
        Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());
         
        // Concatenated the list1 and list2 by converting them into Stream
 
        concatStream.forEach(s -> System.out.print(s + " "));
    }


}
