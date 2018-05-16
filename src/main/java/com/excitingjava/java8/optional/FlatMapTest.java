package com.excitingjava.java8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author: Balogh Ádám Bence
 */
public class FlatMapTest {
    public static void main(String[] args) {
        Optional<Integer> validScholarship = Optional.of(200);
        Optional<Integer> emptyScholarship = Optional.empty();

        Optional<Student> steveStudent = Optional.of(new Student("Steve", validScholarship));
        Optional<Student> johnStudent = Optional.of(new Student("John", emptyScholarship));
        Optional<Student> emptyStudent = Optional.empty();

        //flatMap
        System.out.println(steveStudent.flatMap(student -> student.getScholarship()));
        System.out.println(johnStudent.flatMap(student -> student.getScholarship()));
        System.out.println(emptyStudent.flatMap(student -> student.getScholarship()));
        //if the desired attribute is not an Optional already, we have to wrap it manually
        System.out.println(emptyStudent.flatMap(student -> Optional.ofNullable(student.getName())));
        //Note: instead of student -> student.getScholarship() we could use method reference: Student::getScholarship

        //if the desired attribute is not an Optional already, we have to wrap it manually
        System.out.println(steveStudent.flatMap(student -> Optional.ofNullable(student.getName())));
        System.out.println(emptyStudent.flatMap(student -> Optional.ofNullable(student.getName())));

        //put these three Optionals into a List
        List<Optional<Student>> studentOptionalList = Arrays.asList(steveStudent, johnStudent, emptyStudent);

        //Let's try to get the summary of the scholarships
        int scholarshipsSummary = 0;
        for (Optional<Student> optStudent : studentOptionalList) {
            scholarshipsSummary +=
                    optStudent.flatMap(student -> student.getScholarship()).orElse(0);
        }
        System.out.println(scholarshipsSummary);

        scholarshipsSummary = studentOptionalList
                .stream()
                .mapToInt(studentOpt -> studentOpt.flatMap(Student::getScholarship).orElse(0))
                .sum();
        System.out.println("scholarshipsSummary using stream: " + scholarshipsSummary);

        //Pre Java8 version:
        StudentV2 steveStudentV2 = new StudentV2("Steve", 200);
        StudentV2 johnStudentV2 = new StudentV2("John", null);
        StudentV2 emptyStudentV2 = null;
        List<StudentV2> studentV2List = Arrays.asList(steveStudentV2, johnStudentV2, emptyStudentV2);
        int scholarshipsSummary2 = 0;
        for (StudentV2 actualStudent : studentV2List) {
            if (actualStudent != null && actualStudent.getScholarship() != null) {
                scholarshipsSummary2 += actualStudent.getScholarship();
            }
        }
        System.out.println(scholarshipsSummary2);
    }
}
