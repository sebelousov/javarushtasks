package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;

    public int score = 0;
    public int maxTile = 0;

    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    public void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> listEmptyTiles = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                Tile currentTile = gameTiles[i][j];
                if (currentTile.isEmpty()) listEmptyTiles.add(currentTile);
            }
        }
        return listEmptyTiles;
    }

    private void addTile() {
        List<Tile> listEmptyTiles = getEmptyTiles();
        if (!listEmptyTiles.isEmpty()) {
            Tile tile = listEmptyTiles.get((int) (listEmptyTiles.size() * Math.random()));
            tile.value = (Math.random() < 0.9 ? 2 : 4);
        }
    }

    private boolean compressTiles(Tile[] tiles) {
        //Arrays.sort(tiles, Comparator.comparing(Tile::isEmpty));
        boolean isChanged = false;
        for (int i = 1; i < tiles.length; i++) {
            for (int j = 1; j < tiles.length; j++) {
                if (tiles[j - 1].isEmpty() && !tiles[j].isEmpty()) {
                    tiles[j - 1] = tiles[j];
                    tiles[j] = new Tile();
                    isChanged = true;
                }
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 1; i < tiles.length; i++) {
            if ((tiles[i - 1].value == tiles[i].value) && !tiles[i - 1].isEmpty() && !tiles[i].isEmpty()) {
                tiles[i - 1].value *= 2;
                tiles[i] = new Tile();
                score += tiles[i - 1].value;
                isChanged = true;
                if (tiles[i - 1].value > maxTile) maxTile = tiles[i - 1].value;
                compressTiles(tiles);
            }
        }
        return isChanged;
    }

    private void rotate(Tile[][] gameTiles) {
        Tile[][] rotateTiles = new Tile[gameTiles.length][gameTiles.length];

        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            for (int j = i; j < FIELD_WIDTH - i - 1; j++) {
                Tile tmp = gameTiles[i][j];
                gameTiles[i][j] = gameTiles[FIELD_WIDTH - j - 1][i];
                gameTiles[FIELD_WIDTH - j - 1][i] = gameTiles[FIELD_WIDTH - i - 1][FIELD_WIDTH - j - 1];
                gameTiles[FIELD_WIDTH - i - 1][FIELD_WIDTH - j - 1] = gameTiles[j][FIELD_WIDTH - i - 1];
                gameTiles[j][FIELD_WIDTH - i - 1] = tmp;
            }
        }
    }

    public void left() {
        if (isSaveNeeded) saveState(gameTiles);

        boolean isChanged = false;

        for (int i = 0; i < gameTiles[0].length; i++) {
            boolean isMerged = mergeTiles(gameTiles[i]);
            boolean isCompressed = compressTiles(gameTiles[i]);
            if (isMerged || isCompressed) {
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
            isSaveNeeded = true;
        }
    }

    public void up() {
        saveState(gameTiles);

        for (int i = 0; i < 3; i++) {
            rotate(gameTiles);
        }
        left();
        rotate(gameTiles);
    }

    public void right() {
        saveState(gameTiles);

        for (int i = 0; i < 2; i++) {
            rotate(gameTiles);
        }
        left();
        for (int i = 0; i < 2; i++) {
            rotate(gameTiles);
        }
    }

    public void down() {
        saveState(gameTiles);

        rotate(gameTiles);

        left();

        for (int i = 0; i < 3; i++) {
            rotate(gameTiles);
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;

        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    public void autoMove() {
        Queue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());

        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));

        MoveEfficiency moveEfficiency = queue.peek();
        moveEfficiency.getMove().move();

    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) return true;

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value) return true;
            }
        }

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[j][i].value == gameTiles[j - 1][i].value) return true;
            }
        }

        return false;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] saveTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        int saveScore = score;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                saveTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }

        previousStates.push(saveTiles);
        previousScores.push(saveScore);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty()) gameTiles = previousStates.pop();

        if (!previousScores.isEmpty()) score = previousScores.pop();

    }

    public boolean hasBoardChanged() {
        int gameTilesWeight = 0;
        int saveGameTilesWeight = 0;
        Tile[][] lastSaveTiles = previousStates.peek();

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[0].length; j++) {
                gameTilesWeight += gameTiles[i][j].value;
                saveGameTilesWeight += lastSaveTiles[i][j].value;
            }
        }


        return gameTilesWeight != saveGameTilesWeight;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;

        move.move();

        if (hasBoardChanged()) moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        else moveEfficiency = new MoveEfficiency(-1, 0, move);
        rollback();

        return moveEfficiency;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public void setGameTiles(Tile[][] gameTiles) {
        this.gameTiles = gameTiles;
    }
}
