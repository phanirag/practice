package Streams;

import Streams.models.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFlatMap {

    // map() => mapper function produces single value for each value hence it is called one-to-one mapping
    // flatMap() =>  mapper function produces multiple values for each input value hences it is called one-to-many mapping.
    public static void main(String[] args) {

        List<Customer> customers = MapAndFlatMap.getCustomers();

        // getting list of names
        List<String> names = customers.stream().map(c -> c.getName()).toList();

        // getting phone numbers
        List<List<String>> list = customers.stream().map(c -> c.getPhoneNumbers()).toList();
        Map<Integer, Long> collect = customers.stream().collect(Collectors.groupingBy(c -> c.getId(), Collectors.counting()));
        System.out.println(collect);
        List<String> list1 = customers.stream().flatMap(c -> c.getPhoneNumbers().stream()).toList();
        System.out.println(list1);
    }

    public static List<Customer> getCustomers() {
        return Stream.of(
                new Customer(1, "test", Arrays.asList("1111","1111")),
                new Customer(2, "test", Arrays.asList("1111","1111")),
                new Customer(13, "test", Arrays.asList("1111","1111")),
                new Customer(2, "test1", Arrays.asList("2222","2222")),
                new Customer(3, "test2", Arrays.asList("3333","3333")),
                new Customer(4, "test3", Arrays.asList("4444","44444"))
        ).toList();
    }
}
