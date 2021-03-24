package com.javarush.task.task23.task2312;

import java.util.Arrays;

public class RoomTest {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;



    public RoomTest(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public static void main(String[] args) {
        RoomTest roomTest = new RoomTest(10, 7, new Snake(1, 1));
        roomTest.snake.getSections().add(new SnakeSection(1, 2));
        roomTest.snake.getSections().add(new SnakeSection(1, 3));
        roomTest.snake.getSections().add(new SnakeSection(1, 4));
        roomTest.mouse = new Mouse(6, 6);
        roomTest.print();
    }

    public void print() {
        //Создаем массив, куда будем "рисовать" текущее состояние игры
        //Рисуем все кусочки змеи
        //Рисуем мышь
        //Выводим все это на экран
        int[][] matrix = new int[height][width];

        matrix[snake.getSections().get(0).getY()][snake.getSections().get(0).getX()] = 2;
        for (int i = 1; i < snake.getSections().size(); i++) {
            matrix[snake.getSections().get(i).getY()][snake.getSections().get(i).getX()] = 1;
        }

        matrix[this.getMouse().getY()][this.getMouse().getX()] = 3;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) System.out.print("x");
                else if (matrix[i][j] == 2) System.out.print("X");
                else if (matrix[i][j] == 3) System.out.print("^");
                else System.out.print(".");
            }
            System.out.println();
        }


    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
}
