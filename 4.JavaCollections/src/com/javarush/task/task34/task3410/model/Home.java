package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Home extends GameObject {
    public Home(int x, int y) {
        super(x, y, 2000, 2000);
    }

    @Override
    public void draw(Graphics graphics) {
        int cornerX = getX() - getWidth()/2;
        int cornerY = getY() - getHeight()/2;
        graphics.setColor(Color.RED);
        graphics.fillOval(cornerX, cornerY, getWidth(), getHeight());
    }
}
