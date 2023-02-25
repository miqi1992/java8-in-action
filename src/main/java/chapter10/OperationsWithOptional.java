package chapter10;

import java.util.Optional;

public class OperationsWithOptional {


    public static void main(String[] args) {
        System.out.println(max(8, 4, 5));
    }

    public static final Optional<Integer> max(Integer i, Integer j, Integer k) {
        Optional<Integer> oi = Optional.ofNullable(i);
        Optional<Integer> oj = Optional.ofNullable(j);
        Optional<Integer> ok = Optional.ofNullable(k);
        return oi.flatMap(a -> oj.map(b -> Math.max(a, b)))
                .flatMap(c -> ok.map(d -> Math.max(c, d)));
    }
}
