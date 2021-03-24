package com.javarush.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/* 
Добавление логирования в класс
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        logger.debug("Установка значения поля value1 в конструкторе.");
        this.value1 = value1;
        //logger.debug("Установка значения поля value2 в конструкторе.");
        this.value2 = value2;
        //logger.debug("Установка значения поля value3 в конструкторе.");
        this.value3 = value3;
    }

    public static void main(String[] args) {

    }

    public void calculateAndSetValue3(long value) {
        logger.trace("Началось выполнение метода calculateAndSetValue3.");
        value -= 133;
        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);
            logger.debug("Установка значения поля value1 в методе calculateAndSetValue3 (true).");
        } else {
            value1 = (int) value;
            logger.debug("Установка значения поля value1 в методе calculateAndSetValue3 (false).");
        }
    }

    public void printString() {
        logger.trace("Началось выполнение метода printString.");
        if (value2 != null) {
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        logger.trace("Началось выполнение метода printDateAsLong.");
        if (value3 != null) {
            System.out.println(value3.getTime());
        }
    }

    public void divide(int number1, int number2) {
        logger.trace("Началось выполнение метода divide.");
        try {
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error("Произошла ошибка при делении на ноль.");
        }
    }

    public void setValue1(int value1) {
        logger.debug("Установка значения поля value1 в сеттере.");
        this.value1 = value1;
    }

    public void setValue2(String value2) {
        logger.debug("Установка значения поля value2 в сеттере.");
        this.value2 = value2;
    }

    public void setValue3(Date value3) {
        logger.debug("Установка значения поля value3 в сеттере.");
        this.value3 = value3;
    }
}
