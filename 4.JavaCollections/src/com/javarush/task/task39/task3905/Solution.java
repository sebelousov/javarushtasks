package com.javarush.task.task39.task3905;

/* 
Залей меня полностью
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Color[][] image = new Color[10][10];

        for (int i = 0; i < image.length; i ++) {
            for (int j = 0; j < image[0].length; j++) {
                image[i][j] = Color.BLUE;
            }
        }

        for (int i = 0; i < image[0].length; i++) {
            for (int j = 0; j < image.length; j++) {
                System.out.print(image[i][j].name() + " ");
            }
            System.out.println();
        }

        PhotoPaint photoPaint = new PhotoPaint();
        System.out.println(photoPaint.paintFill(image, 0, 5, Color.RED));

        for (int i = 0; i < image[0].length; i++) {
            for (int j = 0; j < image.length; j++) {
                System.out.print(image[i][j].name() + " ");
            }
            System.out.println();
        }
    }
}
