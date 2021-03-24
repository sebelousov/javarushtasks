package com.javarush.task.task06.task0617;

/* 
Блокнот для новых идей
*/

public class Solution {
    public static void main(String[] args) {
        printIdea(new Idea());
    }

    public class Idea {
        public String getDescription(String idea) {
            return "New idea!";

        }
    }

    public static void printIdea(Idea idea) {
        System.out.println(idea.getDescription("New idea!"));
    }
    //напишите тут ваш код
}