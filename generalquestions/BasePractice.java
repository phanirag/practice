package generalquestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class BasePractice {
    public void StringRevers() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the string: ");
        String val = s.nextLine();
        s.close();

        System.out.println("---- with chararray ---- ");
        char[] chars = val.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }

        System.out.println("---- with string split ----- ");
        String[] split = val.split("");
        for (int i = split.length - 1; i >= 0; i--) {
            System.out.print(split[i]);
        }

        System.out.println("----- with string builder ---- ");
        StringBuilder sb = new StringBuilder(val);
        System.out.println(sb.reverse());

    }

    public void CountWordString() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the string");
        String val = s.nextLine();
        s.close();
        String[] split = val.split(" ");
//        HashMap<String, Integer> result = new HashMap<String, Integer>();
//        for (int i = 0; i <= split.length - 1; i++) {
//            if (result.containsKey(split[i])) {
//                int count = result.get(split[i]);
//                result.put(split[i], count + 1);
//            } else {
//                result.put(split[i], 1);
//            }
//        }

        Map<String, Long> collect = Arrays.stream(split).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

    public void SwapTwoIntValue() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter 2 numbers");
        Integer x = s.nextInt();
        Integer y = s.nextInt();
        System.out.println("Before swap: " + x + "" + y);

        // Integer temp;
        // temp = x;
        // x = y;
        // y = temp;

        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println("After swap: " + x + "" + y);

    }

    public void finbanocci() {
//        int n1=0, n2=1, n3;
//        int count = 10;
//        System.out.println(n1 + "\n" + n2);
//
//        for(int i=2; i<= count; i++) {
//            n3 =n1 + n2;
//            System.out.println(n3);
//            n1 = n2;
//            n2 = n3;
//        }

        Stream.iterate(new long[] { 1, 1 }, p -> new long[] { p[1], p[0] + p[1] })
                .limit(10)
                .forEach(p -> System.out.println(p[0]));
    }
}
