package com.excitingjava.java8.optional;

import java.util.Optional;

/**
 * @author: Balogh Ádám Bence
 */
class Student {
    private String name;
    private Optional<Integer> scholarship;

    public Student(String name, Optional<Integer> scholarship) {
        this.name = name;
        this.scholarship = scholarship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<Integer> getScholarship() {
        return scholarship;
    }

    public void setScholarship(Optional<Integer> scholarship) {
        this.scholarship = scholarship;
    }
}

