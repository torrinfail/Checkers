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
public class Tile {
    
    private Vector2 position;
    private boolean isOccupied;
    private Color color, defaultColor; 
    private GamePiece currentPiece;
    public ArrayList<GamePiece> killPieces = new ArrayList<GamePiece>();
    
    public Tile(Color color, Vector2 position)
    {
        this.color = color;
        defaultColor = color;
        this.position = position;
    }
    
    public Color getDefaultColor()
    {
        return defaultColor;
    }
    
    public Color getColor()
    {
        return color;
    }
    public void setColor(Color c)
    {
        color = c;
    }
    
    public Vector2 getposition()
            {
               return position;
            }
    
    public void setoccupied(boolean b)
            {
                isOccupied = b;
            }
    public boolean getoccupied()
            {
                return isOccupied;
            }
    public Vector2 getIndex()
    {
        return new Vector2(position.getX() / Checkers.squareSize, position.getY() / Checkers.squareSize);
    }
    
    public GamePiece getPiece()
    {
        return currentPiece;
    }
    public void setPiece(GamePiece p)
    {
        currentPiece = p;
        if(p != null)
        {
            isOccupied = true;
        }
        else
        {
            isOccupied = false;
        }
    }
    
    public void killPieces()
    {
        for(GamePiece p : killPieces)
        {
            p.kill();
        }
        killPieces = new ArrayList<GamePiece>();
    }
}
