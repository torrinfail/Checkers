/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author aidan
 */
public class Checkers extends JPanel implements Runnable, KeyListener{
    static int squareSize = 60,counter = 0;
    static int selectedX, selectedY;
    static Color[][] colors = new Color[8][8];
    

    /**
     * @param args the command line arguments
     */
    public Checkers()
    {
        this.addKeyListener(this);
    }
    public void paintComponent(Graphics g)
    {
        boolean toggle = false;
        for(int i = 0; i < colors.length; i++)
        {
            for(int j = 0; j < colors[i].length; j++)
            {
                if(i == selectedY && j == selectedX)
                {
                    g.setColor(Color.pink);
                    g.fillRect(j * squareSize, i * squareSize, squareSize, squareSize);
                    toggle = !toggle;
                }
                else if(toggle)
                {
                    g.setColor(Color.red);
                    g.fillRect(j * squareSize, i * squareSize, squareSize, squareSize);
                    toggle = !toggle;
                }
                
                else
                {
                    g.setColor(Color.black);
                    g.fillRect(j * squareSize, i * squareSize, squareSize, squareSize);
                    toggle = !toggle;
                }
            }
            toggle = !toggle;
        }
        g.setColor(Color.yellow);
        g.drawString(String.format("%d", counter), 12, 12);
        counter++;
        
    }
    public static void main(String[] args) throws InterruptedException 
    {
        for(int i = 0; i < colors.length; i++)
        {
            for(int j = 0; j < colors[i].length; j++)
            {
                if(j%2 == 0)
                {
                    colors[i][j] = Color.red;
                }
               
                else
                {
                    colors[i][j] = Color.black;
                }
            }
        }
        Checkers c = new Checkers();
        JFrame frame = new JFrame();
        frame.setSize(squareSize * 8, squareSize * 8);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(c);
        frame.addKeyListener(c);
        
        
        Thread t = new Thread(c);
        t.join();
        t.start();
        
        
    }
    public static void moveSelection(int x ,int y)
    {
        selectedX += x;
        selectedY += y;
    }
    public void run()
    {
        try{
        while(true)
        {
            repaint();
            Thread.sleep(33);
            
        }
        }
        catch(Exception e)
        {
            
        }
    }
    
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
