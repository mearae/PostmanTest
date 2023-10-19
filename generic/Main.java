import generic.Animal.Dog;
import generic.Factory;
import generic.Generic;

import java.util.List;
import java.util.ArrayList;

import static generic.Generic.output;

public class Main {
    public static void main(String[] args) {
        Integer[] iArray = {1,2,3,4,5};
        output(iArray);
        System.out.println();

        String[] strings = {"a","b","c","d"};
        output(strings);
        System.out.println();

        Factory<Dog> dogFactory = new Factory<>(Dog.class);
        Dog dog = dogFactory.create();
        dog.output();

        List<?> i = new ArrayList<>();
        i = new ArrayList<Integer>();
        i = new ArrayList<String>();
        i = new ArrayList<Long>();
    }
}
