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
public class GamePiece {
    private int position;
    private Color color;
    private boolean kinged;
    private boolean dead; 
    
    public GamePiece(Color color, int position)
    {
        this.color = color;
        this.position = position;         
    }
    public Color getcolor()
    {
        return color;
    }
    
    public int getposition()
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
    
  
            
            
    
}
