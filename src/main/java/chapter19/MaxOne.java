package chapter19;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class MaxOne {

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person("张三", 12), new Person("李四", 14), new Person("王五", 16));

        // 取最大的一个
        Person person = personList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Person::getAge)))
                .get();
        System.out.println(person);

        person = personList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Person::getAge)))
                .orElse(new Person("大二", 1));
        System.out.println(person);

        person = personList.stream()
                .max(Comparator.comparing(Person::getAge))
                .get();
        System.out.println(person);

        Person person1 = personList.stream().reduce(BinaryOperator.maxBy(Comparator.comparing(Person::getAge))).get();

        // 数字去最大的
        int ageMax = personList.stream().mapToInt(Person::getAge).max().getAsInt();
        System.out.println(ageMax);






    }



    static class Person {
        String name;
        Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
