/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author aidan
 */
public class KeyboardInput implements KeyListener
{
    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            Checkers.moveSelection(1, 0);
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            Checkers.moveSelection(-1, 0);
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            Checkers.moveSelection(0, -1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            Checkers.moveSelection(0, 1);
        }
        
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        
    }
    
    
}
