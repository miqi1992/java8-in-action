package chapter05;

import chapter04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping {

    public static void main(String[] args) {
        List<String> dishNames = Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(dishNames);

        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordLengths);

        words.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);

        List<Integer> numbers1 = Arrays.asList(1,2,3,4,5);
        List<Integer> numbers2 = Arrays.asList(6,7,8);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                .collect(Collectors.toList());
        System.out.println(pairs);


        List<Integer> numbers3 = Arrays.asList(10, 11, 12);

        numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new int[]{i, j}))
                .flatMap(pair -> numbers3.stream().map(k -> new int[]{pair[0], pair[1], k}))
                .filter(s -> s[0] + s[1] + s[2] > 20)
                .forEach(triple -> System.out.println("(" + triple[0] + ", " + triple[1] + ", " + triple[2]));
    }
}
