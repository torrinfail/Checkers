/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.awt.Color;

/**
 *
 * @author Whitney Cahoon
 */
public class Board {

    private Tile[][] spaces = new Tile[8][8];

    public Board(Color c1, Color c2) {

        for (int i = 0; i < spaces.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < spaces[0].length; j++) {
                    if (j % 2 == 0) {
                        spaces[i][j] = new Tile(c1, new Vector2(j * Checkers.squareSize, i * Checkers.squareSize));
                    } else {
                        spaces[i][j] = new Tile(c2, new Vector2(j * Checkers.squareSize, i * Checkers.squareSize));
                    }
                }
            } else {
                for (int j = 0; j < spaces[0].length; j++) {
                    if (j % 2 == 0) {
                        spaces[i][j] = new Tile(c2, new Vector2(j * Checkers.squareSize, i * Checkers.squareSize));
                    } else {
                        spaces[i][j] = new Tile(c1, new Vector2(j * Checkers.squareSize, i * Checkers.squareSize));
                    }
                }
            }
        }

    }

    public Tile[][] getSpaces() {
        return spaces;
    }

}
