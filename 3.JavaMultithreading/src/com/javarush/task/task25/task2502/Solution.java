package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws MyExeption {
            //init wheels here
            wheels = new ArrayList<>();
            String[] temp = loadWheelNamesFromDB();
            for (String t : temp) {
                if (t.equals("FRONT_LEFT")) wheels.add(Wheel.FRONT_LEFT);
                if (t.equals("FRONT_RIGHT")) wheels.add(Wheel.FRONT_RIGHT);
                if (t.equals("BACK_LEFT")) wheels.add(Wheel.BACK_LEFT);
                if (t.equals("BACK_RIGHT")) wheels.add(Wheel.BACK_RIGHT);
            }

            if (wheels.size() != 4) throw new MyExeption();

            for (int i = 0; i < wheels.size(); i++) {
                if (!wheels.get(i).toString().equals(temp[i])) throw new MyExeption();
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        for (Wheel w : Wheel.values()) {
            System.out.println(w);
        }
    }
}
