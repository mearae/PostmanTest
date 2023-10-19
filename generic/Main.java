import generic.Animal.Dog;
import generic.Factory;
import generic.Generic;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Generic<Integer> generic1 = new Generic<>();
        Generic<Long> generic2 = new Generic<>();
        Generic<String> generic3 = new Generic<>();

        Integer output1 = generic1.output(10);
        System.out.println(output1);

        Long output2 = generic2.output(20L);
        System.out.println(output2);

        String output3 = generic3.output("Hello World!");
        System.out.println(output3);

        Generic.Inner<String> inner = new Generic.Inner<>();

        String output4 = inner.output("Hello Generic!");
        System.out.println(output4);

        Factory<Dog> dogFactory = new Factory<>(Dog.class);
        Dog dog = dogFactory.create();
        dog.output();

        List<?> i = new ArrayList<>();
        i = new ArrayList<Integer>();
        i = new ArrayList<String>();
        i = new ArrayList<Long>();
    }
}
