package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    int top, left, width, height;
    public Rectangle(int top, int left, int width, int height){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }
    public Rectangle(int top, int left){
        this.top = top;
        this.left = left;
        this.width = 0;
        this.height = 0;
    }
    public Rectangle(int top, int left, int width){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = this.width;
    }
    public Rectangle(){
        this.top = 10;
        this.left = 20;
        this.width = 30;
        this.height = 40;
    }
    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
