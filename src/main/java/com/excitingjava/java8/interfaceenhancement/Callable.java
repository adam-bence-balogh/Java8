package com.excitingjava.java8.interfaceenhancement;

/**
 * @author: Balogh Ádám Bence
 */
public interface Callable {
    default void call(){
        System.out.println("Callable's call");
    }
}
