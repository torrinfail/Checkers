/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

/**
 *
 * @author aidan
 */
public enum Turn{
        PLAYER_1(-1, "Player 1"),
        PLAYER_2(1,"Player 2");
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
