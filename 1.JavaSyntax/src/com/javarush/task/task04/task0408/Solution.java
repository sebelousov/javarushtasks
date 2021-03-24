package com.javarush.task.task04.task0408;

/* 
Хорошо или плохо?
*/

public class Solution {
    public static void main(String[] args) {
        compare(3);
        compare(6);
        compare(5);
    }

    public static void compare(int a) {

        String chislo = "Число ";
        String ravno;

        if (a > 5) {
            ravno = "больше ";
        }
        else {
            if (a == 5){
                ravno = "равно ";
            }
            else {
                ravno = "меньше ";
            }
        }

        System.out.println(chislo + ravno + 5);

        //напишите тут ваш код
    }
}