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
    public Checkers c;
    @Override
    public void keyReleased(KeyEvent e)
    {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                c.cursor.setSelectedPiece(c.board.getSpaces()[c.cursor.getPosition().getY()  / Checkers.squareSize][c.cursor.getPosition().getX() / Checkers.squareSize]);
                break;
            case KeyEvent.VK_RIGHT:
                Checkers.moveSelection(1, 0);
                break;
            case KeyEvent.VK_LEFT:
                Checkers.moveSelection(-1, 0);
                break;
            case KeyEvent.VK_UP:
                Checkers.moveSelection(0, -1);
                break;
            case KeyEvent.VK_DOWN:
                Checkers.moveSelection(0, 1);
                break;
            default:
                break;
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
