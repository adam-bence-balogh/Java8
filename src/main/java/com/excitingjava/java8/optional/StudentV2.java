package com.excitingjava.java8.optional;

/**
 * @author: Balogh Ádám Bence
 */
public class StudentV2 {
    private String name;
    private Integer scholarship;

    public StudentV2(String name, Integer scholarship) {
        this.name = name;
        this.scholarship = scholarship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScholarship() {
        return scholarship;
    }

    public void setScholarship(Integer scholarship) {
        this.scholarship = scholarship;
    }
}
