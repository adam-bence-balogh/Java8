package com.excitingjava.java8.interfaceenhancement;

/**
 * @author: Balogh Ádám Bence
 */
public interface Reachable {
    default void call(){
        System.out.println("Reachable's call");
    }
}
