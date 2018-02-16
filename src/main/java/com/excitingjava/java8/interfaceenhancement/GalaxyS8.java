package com.excitingjava.java8.interfaceenhancement;

/**
 * @author: Balogh Ádám Bence
 */
public class GalaxyS8 extends Phone implements Callable, Reachable{
    public void call(){
        Callable.super.call(); //accessing the Callable interface default method
        Reachable.super.call(); //accessing the Reachable interface default method
        super.call(); //accessing the parent class (Phone) implementation
        System.out.println("GalaxyS8 call");
    }
}
