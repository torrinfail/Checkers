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
    private Turn team;
    private ArrayList <Tile> possibleMoves = new ArrayList <Tile>(); 
    //private Tile[] possibleMoves;
    
    public GamePiece(Color color, Vector2 position, Turn team)
    {
        this.color = color;
        this.position = position;         
        this.team = team;
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
        generatePosibleMoves(tiles, getIndex().getX(), getIndex().getY(), true);
    }
    public void generatePosibleMoves(Tile[][] tiles, int x, int y, boolean firstMove)
    {
        
        try{
        if(!tiles[y + (1* team.direction)][x + 1].getoccupied() && firstMove)
        {
            possibleMoves.add(tiles[y + (1* team.direction)][x + 1]);
        }
        else if(tiles[y + (1* team.direction)][getIndex().getX() + 1].getoccupied() == true
                &&tiles[y + (2* team.direction)][getIndex().getX() + 2].getoccupied() == false)
        {
            possibleMoves.add(tiles[y + (2* team.direction)][x + 2]);
            generatePosibleMoves(tiles,x + 2, y + (2* team.direction), false);
        }
        }
        catch(IndexOutOfBoundsException e){}
        try{
        if(tiles[y + (1* team.direction)][x - 1].getoccupied() == false  && firstMove)
        {
            possibleMoves.add(tiles[y + (1* team.direction)][x - 1]);
        }
        else if(tiles[y + (1* team.direction)][x - 1].getoccupied() == true
                &&tiles[y + (2* team.direction)][x - 2].getoccupied() == false)
        {
            possibleMoves.add(tiles[y + (2* team.direction)][x - 2]);
            generatePosibleMoves(tiles,x - 2, y + (2* team.direction), false);
        }
        
        for (Tile possibleMove : possibleMoves) 
        {
            possibleMove.setColor(Color.GREEN);
        }
        }
        catch(IndexOutOfBoundsException e){}
        
    }
  
     public Vector2 getIndex()
    {
        return new Vector2(position.getX() / Checkers.squareSize, position.getY() / Checkers.squareSize);
    }       
            
    
}
