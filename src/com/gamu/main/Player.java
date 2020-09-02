package com.gamu.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject{
    
    Random r = new Random();
    
    public Player(int x, int y, ID id) {
        super(x, y, id);
        
        
    }

    public void tick() {
        //Adds the velocity to the current position
        x += velX;
        y += velY;
    }

    public void render(Graphics g) {
        //Color of Player 1
        if(id == ID.Player) g.setColor(Color.blue);
        //Color of Player 2
        else if(id == ID.Player2) g.setColor(Color.red);
        //Fills the Player with respective color
        g.fillRect(x, y, 32, 32);
    }
}
