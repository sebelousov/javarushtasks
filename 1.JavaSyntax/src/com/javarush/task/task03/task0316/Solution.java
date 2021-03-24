package com.javarush.task.task03.task0316;

/* 
Экранирование символов
*/

public class Solution {
    public static void main(String[] args) {

        String text = "It's Windows path: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\"";
        int x = 0;

        while (x < 2){
            System.out.println(text);
            x = x + 1;
            text = "It's Java string: \\\"C:\\\\Program Files\\\\Java\\\\jdk1.7.0\\\\bin\\\"";
        }

        //напишите тут ваш код
    }
}
