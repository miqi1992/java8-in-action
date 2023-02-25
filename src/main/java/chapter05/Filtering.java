package chapter05;

import chapter04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static chapter04.Dish.menu;

public class Filtering {


    public static void main(String[] args) {

        //filter
        List<Dish> vegetairMenu = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());

        // distinct
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream().filter(i -> i % 2 == 0)
                .distinct().forEach(System.out::println);



    }
}
