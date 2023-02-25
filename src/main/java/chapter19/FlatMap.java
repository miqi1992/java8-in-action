package chapter19;

import java.util.Arrays;
import java.util.List;

public class FlatMap {
    public static void main(String[] args) {
//        List<String> stringList = Arrays.asList("Hello", "World");
//        List<String> strings = stringList.stream()
//                .map(str -> str.split(""))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(strings);


        List<Integer> a = Arrays.asList(1, 2, 3, 4);
        List<Integer> b = Arrays.asList(4,5,6);
        List<Integer> c = Arrays.asList(7,8,9);
        a.stream()
                .flatMap(x -> b.stream().map(j -> new int[]{x, j}))
                .flatMap(xj -> c.stream().map(z -> new int[]{xj[0], xj[1], z}))
                        .forEach(xjz  -> System.out.println("["+xjz[0]+ ", "+ xjz[1] + ", " + xjz[2]));
    }
}
