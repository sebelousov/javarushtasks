package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String s) {
        String result = "";
        for (int i = 5; i > 0; i--){
            result = result + s;
            System.out.println();
        }
        //напишите тут ваш код
        return result;
    }

    public static String multiply(String s, int count) {
        String result = "";
        for (; count > 0; count--){
            result = result + s;
        }
        //напишите тут ваш код
        return result;
    }

    public static void main(String[] args) {

    }
}
