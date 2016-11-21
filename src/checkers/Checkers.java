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
public class Checkers extends JPanel{
    static int squareSize = 60,counter = 0;
    static int selectedX, selectedY;
    static Vector2 selectedSquare = new Vector2(0,0);
    static Color[][] colors = new Color[8][8];
    static Color primaryColor = Color.LIGHT_GRAY, secondaryColor = Color.darkGray, primaryPieceColor = Color.black, secondaryPieceColor = Color.red;
    

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
                if(i == selectedSquare.getY() && j == selectedSquare.getX())
                {
                    g.setColor(Color.pink);
                    g.fillRect(j * squareSize, i * squareSize, squareSize, squareSize);
                    toggle = !toggle;
                }
                else if(toggle)
                {
                    g.setColor(primaryColor);
                    g.fillRect(j * squareSize, i * squareSize, squareSize, squareSize);
                    toggle = !toggle;
                }
                
                else
                {
                    g.setColor(secondaryColor);
                    g.fillRect(j * squareSize, i * squareSize, squareSize, squareSize);
                    toggle = !toggle;
                }
            }
            toggle = !toggle;
        }
        g.setColor(primaryPieceColor);
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 8; j += 2)
            {
                g.fillOval(j * squareSize, i * squareSize, squareSize, squareSize);
            }
        }
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
        KeyboardInput input = new KeyboardInput();
        
        JFrame frame = new JFrame();
        frame.setSize(squareSize * colors[0].length, squareSize * colors.length);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(c);
        frame.addKeyListener(input);
        
        c.gameLoop();
        //Thread t = new Thread(c);
        //t.join();
        //t.start();
        
        
    }
    public static void moveSelection(int x ,int y)
    {
        selectedSquare.addX(x);
        selectedSquare.addY(y);
        
        if(selectedSquare.getX() > colors.length-1)
        {
            selectedSquare.setX(0);
        }
        else if(selectedSquare.getX() < 0)
        {
            selectedSquare.setX(colors.length-1);
        }
        
        if(selectedSquare.getY() > colors.length-1)
        {
            selectedSquare.setY(0);
        }
        else if(selectedSquare.getY() < 0)
        {
            selectedSquare.setY(colors.length-1);
        }
    }
    public void gameLoop()
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
