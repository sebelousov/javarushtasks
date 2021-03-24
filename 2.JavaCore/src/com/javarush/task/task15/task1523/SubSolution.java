package com.javarush.task.task15.task1523;

public class SubSolution extends Solution {

    int a;
    int b;
    int c;
    int d;

    SubSolution(int a, int a1) {
        super(a);
        this.a = a1;
    }

    protected SubSolution(int a, int b, int c, int a1, int b1) {
        super(a, b, c);
        this.a = a1;
        this.b = b1;
    }

    public SubSolution(int a, int b, int c, int d, int a1, int b1, int c1, int d1) {
        super(a, b, c, d);
        this.a = a1;
        this.b = b1;
        this.c = c1;
        this.d = d1;
    }
}
