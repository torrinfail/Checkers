/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

/**
 *
 * @author ahubert1
 */
public class Vector2 
{
    private int x, y;
    public Vector2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public void addX(int n)
    {
        x+=n;
    }
    
    public void addY(int n)
    {
        y+=n;
    }
    public void setX(int newX)
    {
        x = newX;
    }
    
    public void setY(int newY)
    {
        y = newY;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public boolean equals(Vector2 other)
    {
        return this.x == other.getX() && this.y == other.getY();
    }
}
