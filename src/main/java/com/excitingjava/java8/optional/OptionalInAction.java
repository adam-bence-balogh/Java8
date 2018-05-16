package com.excitingjava.java8.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author: Balogh Ádám Bence
 */
public class OptionalInAction {
    public static void main(String[] args) {
        //Creates an empty Optional
        Optional<String> opt1 = Optional.empty();
        System.out.println(opt1);

        try {
            //Optional.of throws a NPE if the given value is null
            Optional<String> opt2 = Optional.of(null);
        } catch (NullPointerException npe) {
            System.out.println(npe);
        }

        //Optional is created wrapping the "TestValue" String
        Optional<String> opt3 = Optional.of("TestValue");
        System.out.println(opt3);

        //Creates an empty Optional, because the given value is null
        Optional<String> opt4 = Optional.ofNullable(null);
        System.out.println(opt4);

        //Getting value from an Optional
        try {
            //get() throws Exception if the Optional is empty, use it only if you checked it has a value
            String s1 = opt1.get();
        } catch (NoSuchElementException nsee) {
            System.out.println(nsee);
        }

        String s2 = opt3.get();
        System.out.println(s2);

        //orElse() returns the value if it's present or an alternative if it's empty
        String s3 = opt1.orElse("alternative value");
        System.out.println(s3);

        String s4 = opt3.orElse("alternative value");
        System.out.println(s4);

        //orElseGet() is similar to orElse, but this method requires a Supplier which is going to be called and produce a value if the Optional is empty
        String s5 = opt1.orElseGet(() -> "alternative value");
        System.out.println(s5);

        String s6 = opt3.orElseGet(() -> "alternative value");
        System.out.println(s6);

        try {
            //orElseThrow() returns the value if it's present (just like orElse and orElseGet), but this method will throw an Exception defined by a Supplier
            String s7 = opt1.orElseThrow(() -> new RuntimeException("this exception will be thrown if value is not presented"));
        } catch (RuntimeException re) {
            System.out.println(re);
        }
        String s8 = opt3.orElseThrow(() -> new RuntimeException("this exception will be thrown if value is not presented"));
        System.out.println(s8);

        //How to check whether the Optional contains a value or not

        //the isPresent() returns true if the Optional has a value, and false if the Optional is empty
        System.out.println(opt1.isPresent());
        System.out.println(opt3.isPresent());

        //ifPresent(Consumer c) requires a Consumer as argument, and it will be executed if the Optional is not empty
//The Consumer's is the value wrapped by the Optional
        opt1.ifPresent(value -> System.out.println("This won't be executed, because opt1 is empty"));
        opt3.ifPresent(value -> System.out.println("This will be executed, wrapped value: " + value));
    }
}
