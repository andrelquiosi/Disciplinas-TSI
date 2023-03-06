package domain;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {

        List<Animal> animals = Arrays.asList(new Cat(), new Spider(), new Cat("Tekir"), new Fish("Free Hilly"),
                new Spider(), new Fish("Jaws"));

        Predicate<Animal> isPet = Pet.class::isInstance;
        Predicate<Animal> isWild = isPet.negate();
        
        // 1
        // animals.stream().filter(isWild).collect(Collectors.toList()).forEach(System.out::println);

        // 2
        // animals.stream().map(Object::getClass).map(Class::getName).distinct().forEach(System.out::println);

        // 3 Find the animal with the highest number of legs
        // animals.stream().max(Comparator.comparing(Animal::getLegs))
        //         .ifPresent(animal -> System.out.println(animal.getClass().getName()));

        // 4 Take alis of 100 random animals
        // System.out.println(new SecureRandom().nextInt(10));
        // Stream.generate(() -> "a").forEach(System.out::println);

        IntStream.generate(() -> new SecureRandom().nextInt(10000)).forEach(System.out::println);

    }
}
