package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        int x = 1;
        int y = 10;
        String s = "8";

        for (; y > 0; y--){
            for (int i = x; i > 0; i--){
                System.out.print(s);
            }
            System.out.println();
            x++;
        }
        //напишите тут ваш код

    }
}
