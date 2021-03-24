package com.javarush.task.task34.task3410.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        int cellSize = Model.FIELD_CELL_SIZE / 2;

        Set<Wall> walls = new HashSet<>();
        walls.add(new Wall(cellSize, 13 * cellSize));
        walls.add(new Wall(cellSize, 11 * cellSize));

        Set<Box> boxes = new HashSet<>();
        boxes.add(new Box(7 * cellSize, 5 * cellSize));

        Set<Home> homes = new HashSet<>();
        Home home = new Home(9 * cellSize, 13 * cellSize);
        homes.add(home);
        Player player = new Player(3 * cellSize, 3 * cellSize);

        return new GameObjects(
                walls,
                boxes,
                homes,
                player
        );
    }
}
