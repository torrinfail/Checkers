/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author aidan
 */
public class Checkers extends JPanel implements Runnable{
    static int squareSize = 60,counter = 0;
    static int selectedX, selectedY;
    static Color[][] colors = new Color[8][8];
    

    /**
     * @param args the command line arguments
     */
    @Override
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
        g.fillOval(0, 0, squareSize, squareSize);
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
        KeyboardInput input = new KeyboardInput();
        
        JFrame frame = new JFrame();
        frame.setSize(squareSize * colors[0].length, squareSize * colors.length);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(c);
        frame.addKeyListener(input);
        
        
        Thread t = new Thread(c);
        t.join();
        t.start();
        
        
    }
    public static void moveSelection(int x ,int y)
    {
        selectedX += x;
        selectedY += y;
        
        if(selectedX > colors.length-1)
        {
            selectedX = 0;
        }
        else if(selectedX < 0)
        {
            selectedX = colors.length-1;
        }
        
        if(selectedY > colors.length-1)
        {
            selectedY = 0;
        }
        else if(selectedY < 0)
        {
            selectedY = colors.length-1;
        }
    }
    public void run()
    {
        try
        {
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
    
    
}
