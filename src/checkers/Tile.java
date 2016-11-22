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
public class Tile {
    
    private Vector2 position;
    private boolean isOccupied;
    private Color color; 
    
    public Tile(Color color, Vector2 position)
    {
        this.color = color;
        this.position = position;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public Vector2 getposition()
            {
               return position;
            }
    
    public boolean setoccupied()
            {
                return isOccupied;
            }
    public boolean getoccupied()
            {
                return isOccupied;
            }
}
