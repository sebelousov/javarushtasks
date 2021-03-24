package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    int top, left, width, height;

    public void initialize(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }
    public void initialize(int top, int left) {
        this.top = top;
        this.left = left;
    }
    public void initialize(int top, int width, int height) {
        this.top = top;
        this.width = width;
        this.height = height;
    }
    public void initialize(int left) {
        this.left = left;
    }

    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
