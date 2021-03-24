package com.javarush.task.task21.task2109;

import java.util.Objects;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            A a = (A) o;
            return i == a.i &&
                    j == a.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        @Override
        protected A clone() throws CloneNotSupportedException {
            return (A) super.clone();
        }

        @Override
        public String toString() {
            return "A{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }

    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }



        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            try {
                return (C) super.clone();
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public String toString() {
            return "C{" +
                    "i=" + super.getI() +
                    ", j=" + super.getJ() +
                    ", name='" + super.getName() + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        A classA = new A(1, 2);
        B classB = new B(3, 4, "Tom");
        C classC = new C(5,6, "Vova");
        B cloneClassB = (B) classB.clone();

        //System.out.println(cloneClassA);

    }
}
