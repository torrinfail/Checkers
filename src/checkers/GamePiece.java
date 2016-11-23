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
    private Vector2 position;
    private Color color;
    private boolean kinged;
    private boolean dead; 
    private ArrayList <Tile> possibleMoves = new ArrayList <Tile>(); 
    //private Tile[] possibleMoves;
    
    public GamePiece(Color color, Vector2 position)
    {
        this.color = color;
        this.position = position;         
    }
    public Color getcolor()
    {
        return color;
    }
    
    public Vector2 getposition()
    {
        return position;
    }
    
    public boolean getkinged()
    {
        return kinged;
    }
    
    public void moveposition()
    {
        
    }
    
    public boolean setkinged()
    {
        return kinged;
    }
    
    public void generatePosibleMoves(Tile[][] tiles)
    {
        if(tiles[getIndex().getY() - 1][getIndex().getX() + 1].getoccupied() == false)
        {
            possibleMoves.add(tiles[getIndex().getY() - 1][getIndex().getX() + 1]);
        }
        else if(tiles[getIndex().getY() - 1][getIndex().getX() + 1].getoccupied() == true
                &&tiles[getIndex().getY() - 2][getIndex().getX() + 2].getoccupied() == false)
        {
            possibleMoves.add(tiles[getIndex().getY() - 2][getIndex().getX() + 2]);
        }
        
        if(tiles[getIndex().getY() + 1][getIndex().getX() + 1].getoccupied() == false)
        {
            possibleMoves.add(tiles[getIndex().getY() + 1][getIndex().getX() + 1]);
        }
        else if(tiles[getIndex().getY() - 1][getIndex().getX() + 1].getoccupied() == true
                &&tiles[getIndex().getY() - 2][getIndex().getX() + 2].getoccupied() == false)
        {
            possibleMoves.add(tiles[getIndex().getY() - 2][getIndex().getX() + 2]);
        }
        
        for (Tile possibleMove : possibleMoves) 
        {
            possibleMove.setColor(Color.GREEN);
        }
    }
  
     public Vector2 getIndex()
    {
        return new Vector2(position.getX() / Checkers.squareSize, position.getY() / Checkers.squareSize);
    }       
            
    
}
