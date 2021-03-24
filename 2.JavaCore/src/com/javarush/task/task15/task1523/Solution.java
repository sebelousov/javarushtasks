package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {

    int a;
    int b;
    int c;
    int d;

    public Solution(int a) {
    }

    private Solution(int a, int b) {
        this.a = a;
        this.b = b;
    }

    protected Solution(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Solution(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public static void main(String[] args) {

    }
}

