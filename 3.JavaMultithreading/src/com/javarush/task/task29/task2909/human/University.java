package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        List<Student> list = students.stream().filter(a -> a.getAverageGrade() == averageGrade).collect(Collectors.toList());;
        return list.get(0);
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        students.sort((s1, s2) -> {
            if (s1.getAverageGrade() > s2.getAverageGrade()) return 1;
            else if (s1.getAverageGrade() < s2.getAverageGrade()) return -1;
            else return 0;
        });
        return students.get(students.size() - 1);
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        students.sort((s1, s2) -> {
            if (s1.getAverageGrade() > s2.getAverageGrade()) return 1;
            else if (s1.getAverageGrade() < s2.getAverageGrade()) return -1;
            else return 0;
        });
        return students.get(0);
    }

    public void expel(Student student) {
        students.remove(student);
    }
}