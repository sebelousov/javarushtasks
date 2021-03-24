package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;

    public EventListener eventListener;

    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(
            Paths.get(
                    Model.class
                            .getPackage()
                            .getName()
                            .replace(".", "/")
                            + "rec/levels.txt")
    );

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall w : gameObjects.getWalls()) {
            if (gameObject.isCollision(w, direction)) return true;
        }
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvaliable(Direction direction) {
        Player player = gameObjects.getPlayer();
        int xPlayer = player.getX();
        int yPlayer = player.getY();

        switch (direction) {
            case UP:
                yPlayer -= Model.FIELD_CELL_SIZE;
                if (isBoxInThisPoint(xPlayer, yPlayer) && isWallInThisPoint(xPlayer, yPlayer - Model.FIELD_CELL_SIZE)) return true;
                else if (isBoxInThisPoint(xPlayer, yPlayer) && isBoxInThisPoint(xPlayer, yPlayer - Model.FIELD_CELL_SIZE)) return true;
                else if (isBoxInThisPoint(xPlayer, yPlayer) && !isBoxInThisPoint(xPlayer, yPlayer - Model.FIELD_CELL_SIZE) && !isWallInThisPoint(xPlayer, yPlayer - Model.FIELD_CELL_SIZE)) {
                    for (Box e : gameObjects.getBoxes()) {
                        if (xPlayer == e.getX() && yPlayer == e.getY()) {
                            e.setX(xPlayer);
                            e.setY(yPlayer);
                            break;
                        }
                    }
                }
                break;
            case DOWN:
                yPlayer += Model.FIELD_CELL_SIZE;
                if (isBoxInThisPoint(xPlayer, yPlayer) && isWallInThisPoint(xPlayer, yPlayer + Model.FIELD_CELL_SIZE)) return true;
                else if (isBoxInThisPoint(xPlayer, yPlayer) && isBoxInThisPoint(xPlayer, yPlayer + Model.FIELD_CELL_SIZE)) return true;
                else if (isBoxInThisPoint(xPlayer, yPlayer) && !isBoxInThisPoint(xPlayer, yPlayer + Model.FIELD_CELL_SIZE) && !isWallInThisPoint(xPlayer, yPlayer + Model.FIELD_CELL_SIZE)) {
                    for (Box e : gameObjects.getBoxes()) {
                        if (xPlayer == e.getX() && yPlayer == e.getY()) {
                            e.setX(xPlayer);
                            e.setY(yPlayer);
                            break;
                        }
                    }
                }
                break;
            case LEFT:
                xPlayer -= Model.FIELD_CELL_SIZE;
                if (isBoxInThisPoint(xPlayer, yPlayer) && isWallInThisPoint(xPlayer - Model.FIELD_CELL_SIZE, yPlayer)) return true;
                else if (isBoxInThisPoint(xPlayer, yPlayer) && isBoxInThisPoint(xPlayer - Model.FIELD_CELL_SIZE, yPlayer)) return true;
                else if (isBoxInThisPoint(xPlayer, yPlayer) && !isBoxInThisPoint(xPlayer - Model.FIELD_CELL_SIZE, yPlayer) && !isWallInThisPoint(xPlayer - Model.FIELD_CELL_SIZE, yPlayer)) {
                    for (Box e : gameObjects.getBoxes()) {
                        if (xPlayer == e.getX() && yPlayer == e.getY()) {
                            e.setX(xPlayer);
                            e.setY(yPlayer);
                            break;
                        }
                    }
                }
                break;
            case RIGHT:
                xPlayer += Model.FIELD_CELL_SIZE;
                if (isBoxInThisPoint(xPlayer, yPlayer) && isWallInThisPoint(xPlayer + Model.FIELD_CELL_SIZE, yPlayer)) return true;
                else if (isBoxInThisPoint(xPlayer, yPlayer) && isBoxInThisPoint(xPlayer + Model.FIELD_CELL_SIZE, yPlayer)) return true;
                else if (isBoxInThisPoint(xPlayer, yPlayer) && !isBoxInThisPoint(xPlayer + Model.FIELD_CELL_SIZE, yPlayer) && !isWallInThisPoint(xPlayer + Model.FIELD_CELL_SIZE, yPlayer)) {
                    for (Box e : gameObjects.getBoxes()) {
                        if (xPlayer == e.getX() && yPlayer == e.getY()) {
                            e.setX(xPlayer);
                            e.setY(yPlayer);
                            break;
                        }
                    }
                }
                break;

        }

        return false;
    }

    private boolean isBoxInThisPoint(int x, int y) {
        for (Box b : gameObjects.getBoxes()) {
            if (b.getX() == x && b.getY() == y) return true;
        }
        return false;
    }

    private boolean isWallInThisPoint(int x, int y) {
        for (Wall e : gameObjects.getWalls()) {
            if (e.getX() == x && e.getY() == y) return true;
        }
        return false;
    }

    private boolean isHomeInThisPoint(int x, int y) {
        for (Home e : gameObjects.getHomes()) {
            if (e.getX() == x && e.getY() == y) return true;
        }
        return false;
    }

    public void move(Direction direction) {

    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restartLevel(currentLevel);
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
