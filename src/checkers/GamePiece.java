/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Whitney Cahoon
 */
public class GamePiece {

    private Vector2 position, startPosition;
    private Color color;
    private boolean kinged;
    private boolean dead;
    private Turn team;
    private ArrayList<Tile> possibleMoves = new ArrayList<Tile>();
    private Tile[][] tiles;

    public GamePiece(Color color, Vector2 position, Turn team, Tile[][] tiles) {
        this.color = color;
        this.position = position;
        this.startPosition = position;
        this.team = team;
        this.tiles = tiles;
    }

    public Color getcolor() {
        return color;
    }

    public Vector2 getposition() {
        return position;
    }

    public boolean getkinged() {
        return kinged;
    }

    public void movePosition(Tile t) {
        if (possibleMoves.size() > 0) {
            for (Tile possibleMove : possibleMoves) {
                if (possibleMove.equals(t)) {
                    tiles[getIndex().getY()][getIndex().getX()].setoccupied(false);
                    tiles[getIndex().getY()][getIndex().getX()].setPiece(null);
                    if(getIndex().getY() > t.getIndex().getY() + 1 || getIndex().getY() < t.getIndex().getY() - 1)
                    {
                        t.killPieces();
                    }
                    position.setX(t.getposition().getX());
                    position.setY(t.getposition().getY());
                    t.setoccupied(true);
                    t.setPiece(this);
                    
                    setkinged();
                    break;
                }
            }
        }
    }

    public void setkinged() {
       if(team == Turn.PLAYER_1 && getIndex().getY() == 0)
       {
           kinged = true;
       }
       else if(team == Turn.PLAYER_2 && getIndex().getY() == 7)
       {
           kinged = true;
       }
       
    }

    public void generatePosibleMoves(Tile[][] tiles) {
        generatePosibleMoves(tiles, getIndex().getX(), getIndex().getY(), true);
    }

    public void generatePosibleMoves(Tile[][] tiles, int x, int y, boolean firstMove) {

        try {
            if (!tiles[y + (1 * team.direction)][x + 1].getoccupied() && firstMove) {
                possibleMoves.add(tiles[y + (1 * team.direction)][x + 1]);
            } else if (tiles[y + (1 * team.direction)][x + 1].getoccupied() == true
                    && tiles[y + (1 * team.direction)][x + 1].getPiece().team != this.team
                    && tiles[y + (2 * team.direction)][x + 2].getoccupied() == false) {
                possibleMoves.add(tiles[y + (2 * team.direction)][x + 2]);
                tiles[y + (2 * team.direction)][x + 2].killPieces.add(tiles[y + (1 * team.direction)][x + 1].getPiece());
                generatePosibleMoves(tiles, x + 2, y + (2 * team.direction), false);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }
        try {
            if (tiles[y + (1 * team.direction)][x - 1].getoccupied() == false && firstMove) {
                possibleMoves.add(tiles[y + (1 * team.direction)][x - 1]);
            } else if (tiles[y + (1 * team.direction)][x - 1].getoccupied() == true
                    && tiles[y + (1 * team.direction)][x - 1].getPiece().team != this.team
                    && tiles[y + (2 * team.direction)][x - 2].getoccupied() == false) {
                possibleMoves.add(tiles[y + (2 * team.direction)][x - 2]);
                tiles[y + (2 * team.direction)][x - 2].killPieces.add(tiles[y + (1 * team.direction)][x - 1].getPiece());
                generatePosibleMoves(tiles, x - 2, y + (2 * team.direction), false);
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }

        for (Tile possibleMove : possibleMoves) {
            possibleMove.setColor(Color.GREEN);
        }

    }

    public void cleanup() {
        for (Tile possibleMove : possibleMoves) {
            possibleMove.setColor(possibleMove.getDefaultColor());
        }
        possibleMoves = new ArrayList<Tile>();
    }
    
    public void kill()
    {
        dead = true;
        tiles[getIndex().getY()][getIndex().getX()].setoccupied(false);
        tiles[getIndex().getY()][getIndex().getX()].setPiece(null);
    }

    public Vector2 getIndex() {
        return new Vector2(position.getX() / Checkers.squareSize, position.getY() / Checkers.squareSize);
    }
    
    public boolean isDead()
    {
        return dead;
    }

}
