/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.awt.Color;

/**
 *
 * @author ahubert1
 */
public class Cursor 
{
    private Vector2 position, selectedPosition;
    private GamePiece selectedPiece;
    private Color color, validColor, invalidColor;
    
    public Cursor(Color color, Vector2 position)
    {
        this.color = color;
        movePosition(position);
    }
    
    public void movePosition(Vector2 newPosition)
    {
        position = newPosition;
    }
    public Vector2 getPosition()
    {
        return position;
    }
    
    public void setSelectedPosition(Vector2 newPosition)
    {
        selectedPosition = newPosition;
    }
    public Vector2 getSelectedPosition()
    {
        return selectedPosition;
    }
    
    public void setSelectedPiece(GamePiece p)
    {
        
            selectedPiece = p;
        
    }
    public GamePiece getSelectedPiece()
    {
        return selectedPiece;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public Color getvalidColor()
    {
        return validColor;
    }
    
    public Color getinvalidColor()
    {
        return invalidColor;
    }
    
    public void setvalidColor(Color newColor)
    {
        validColor = newColor;
    }
    
    public void setinvalidColor(Color newInvalidColor)
    {
        invalidColor = newInvalidColor;
    }
    public Vector2 getIndex()
    {
        return new Vector2(position.getX() / Checkers.squareSize,position.getY() / Checkers.squareSize);
    }
    
    
    
}
