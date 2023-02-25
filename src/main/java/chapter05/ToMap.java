package chapter05;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToMap {


    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("陈奇", 12));
        personList.add(new Person("陈奇2", 12));
        personList.add(new Person("陈奇3", 13));
        personList.add(new Person("陈奇4", 14));

        Map<Integer, Person> mapPersonList = personList.stream().collect(Collectors.toMap(Person::getScore, Function.identity(), (p1, p2)-> {
            if(p1.getName().length() < p2.getName().length()) {
                return p1;
            } else {
                return p2;
            }
        }));
        System.out.println(mapPersonList);


        Map<Integer, List<String>> nameMap = personList.stream().collect(Collectors.groupingBy(Person::getScore, Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println(nameMap)         ;


    }


    static class Person {
        String name;

        Integer score;


        public Person(String name, Integer score) {
            this.name = name;
            this.score = score;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
