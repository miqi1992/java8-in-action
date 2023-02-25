package chapter10;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Person person = new Person();
        String name = Optional.ofNullable(person)
                .flatMap(Person::getCar)
                    .flatMap(Car::getInsurance)
                .map(Insurance::getName).orElse("12321");
        System.out.println(name);
    }

}


class Person {
    private Car car;

    public Optional<Car> getCar() {return Optional.ofNullable(car);}
}

class Car {
    private Insurance insurance;
    public Optional<Insurance> getInsurance() {return Optional.ofNullable(insurance);}

}

class Insurance {
    private String name;
    public String getName() {return name;}
}
