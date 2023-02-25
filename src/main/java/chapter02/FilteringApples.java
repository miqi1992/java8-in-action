package chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {


    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));
        // 1. 筛选绿苹果
        List<Apple> result = filterGreenApples(inventory);

        // 2. 把颜色作为参数
        List<Apple> redApples = filterApplesByColor(inventory, "red");
        List<Apple> greenApples = filterApplesByColor(inventory, "green");

        // 3. 根据重量进行筛选
        List<Apple> heavyApples = filterApplesByWeight(inventory, 110);

        // 4. 通过接口实现行为参数化
        List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());

        // 5. 通过匿名类实现行为参数化
        List<Apple> heavyApples2 = filter(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple a) {
                return a.getWeight() > 150;
            }
        });

        // 6. 通过lambda表达式传递
        List<Apple> heavyApples3 = filter(inventory, a -> a.getWeight() > 150);

    }


     public static List<Apple> filterGreenApples(List<Apple> inventory) {
         List<Apple> result = new ArrayList<>();
         for (Apple apple : inventory) {
             if ("green".equals(apple.getColor())) {
                 result.add(apple);
             }
         }
        return result;
    }


    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate applePredicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    interface ApplePredicate {
        public boolean test(Apple a);
    }

    static class AppleWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple a) {
            return a.getWeight() > 150;
        }
    }


    static class AppleColorPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple a) {
            return "green".equals(a.getColor());
        }
    }



    public static class Apple{
        private int weight = 0;

        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}
