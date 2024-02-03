package Streams;

import Streams.models.Employe;

import java.util.List;
import java.util.stream.IntStream;

public class SteamAndParllelStream {
    public static void main(String[] args) {
        long start = 0;
        long end= 0;
//
//        start = System.currentTimeMillis();
//        IntStream.range(1,100).forEach(System.out::println);
//        end = System.currentTimeMillis();
//
//        System.out.println("Plain stream took time: "+ (end - start));
//
//        System.out.println("======================================");
//
//        start = System.currentTimeMillis();
//        IntStream.range(1,100).parallel().forEach(System.out::println);
//        end = System.currentTimeMillis();
//
//        System.out.println("Parllel stream took time: "+ (end - start));

//        IntStream.range(1,10).forEach(
//                x-> System.out.println("Thread : " + Thread.currentThread().getName() + "" + x)
//        );
//
//        IntStream.range(1,10).parallel().forEach(
//                x -> System.out.println("Thread : " + Thread.currentThread().getName() + "" + x)
//        );

        List<Employe> employes = Employe.getEmployees();

        start = System.currentTimeMillis();
        Double d =employes.stream().map(Employe::getSalary).mapToDouble(Double::valueOf).average().getAsDouble();
        end = System.currentTimeMillis();

        System.out.println("value is "+d +"Time taken : " + (end - start));

        start = System.currentTimeMillis();
        Double d1 =employes.parallelStream().map(Employe::getSalary).mapToDouble(Double::valueOf).average().getAsDouble();
        end = System.currentTimeMillis();

        System.out.println("value is "+ d1 +"Time taken : " + (end - start));
    }
}
