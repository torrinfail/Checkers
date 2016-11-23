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
    static int squareSize = 80,counter = 0;
    static int selectedX, selectedY;
    static Vector2 selectedSquare = new Vector2(0,0);
    static Color[][] colors = new Color[8][8];
    public Board board = new Board(Color.LIGHT_GRAY, Color.black);
    public Cursor cursor = new Cursor(Color.cyan, new Vector2 (0,0));
    static Color primaryColor = Color.LIGHT_GRAY, secondaryColor = Color.darkGray, primaryPieceColor = Color.black, secondaryPieceColor = Color.red;
    public enum Turn{
        PLAYER_1(1, "Player 1"),
        PLAYER_2(-1,"Player 2");
        public final int direction;
        private final String label;
        Turn(int direction, String label)
        {
            this.direction = direction;
            this.label = label;
        }
        @Override
        public String toString()
        {
            return label;
        }
    }
    public Turn turn;
    

    /**
     * @param args the command line arguments
     */
    @Override
    public void paintComponent(Graphics g)
    {
        Tile[][] spaces = this.board.getSpaces();
        for(int i = 0; i < this.board.getSpaces().length; i++)
        {
            for(int j = 0; j < this.board.getSpaces()[0].length; j++)
            {
                if(i == this.cursor.getPosition().getY() && j == this.cursor.getPosition().getX())
                {
                    g.setColor(this.cursor.getColor());
                }
                else
                {
                    g.setColor(this.board.getSpaces()[i][j].getColor());
                }
                g.fillRect(spaces[i][j].getposition().getX(), spaces[i][j].getposition().getY(), squareSize, squareSize);
            }
        }
        g.drawString(this.turn.toString(), squareSize * colors.length, 45);
    }

    public static void main(String[] args) throws InterruptedException 
    {
        

        Checkers c = new Checkers();
        KeyboardInput input = new KeyboardInput();
        
        JFrame frame = new JFrame();
        frame.setSize(squareSize * colors[0].length, squareSize * colors.length);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(c);
        frame.addKeyListener(input);
        c.turn = Turn.PLAYER_2;
        
        c.gameLoop();        
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
                this.cursor.movePosition(selectedSquare);
                Thread.sleep(33);
            }
        }
        catch(InterruptedException e){}
    }
    
    
}
