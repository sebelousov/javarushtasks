package com.javarush.task.task29.task2907;

import javax.swing.plaf.nimbus.State;
import java.math.BigDecimal;

/* 
Этот странный BigDecimal
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getValue(1.1d, 1.2d));
    }

    public static BigDecimal getValue(double v1, double v2) {
        String v1Temp = String.valueOf(v1);
        String v2Temp = String.valueOf(v2);
        return new BigDecimal(v1Temp).add(new BigDecimal(v2Temp));
    }
}