package com.excitingjava.java8.optional;

import java.util.Optional;

/**
 * @author: Balogh Ádám Bence
 */
public class MapTest {
    public static void main(String[] args) {
        Optional<StudentV2> steveStudentV2 = Optional.ofNullable(new StudentV2("Steve", 200));
        Optional<StudentV2> johnStudentV2 = Optional.ofNullable(new StudentV2("John", null));
        Optional<StudentV2> emptyStudentV2 = Optional.ofNullable(null);

        Optional<Integer> stevesScholarship = steveStudentV2.map(StudentV2::getScholarship);
        Optional<Integer> johnsScholarship = johnStudentV2.map(StudentV2::getScholarship);
        Optional<Integer> emptysScholarship = emptyStudentV2.map(StudentV2::getScholarship);
        System.out.println(stevesScholarship);
        System.out.println(johnsScholarship);
        System.out.println(emptysScholarship);
    }
}
