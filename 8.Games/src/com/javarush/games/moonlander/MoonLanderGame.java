package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private Rocket rocket;

    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        rocket = new Rocket(WIDTH / 2, 0);
        drawScene();
    }

    private void drawScene() {
        for (int i = 1; i < WIDTH; i++) {
            for (int j = 1; j < HEIGHT; j++) {
                setCellColor(i, j, Color.BLACK);
            }
        }
        rocket.draw(this);
    }
}
