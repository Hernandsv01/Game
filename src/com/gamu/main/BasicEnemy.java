package com.gamu.main;

import java.awt.Color;
import java.awt.Graphics;

public class BasicEnemy extends GameObject{

    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);
        
        //BasicEnemy velocity
        velX = 5;
        velY = 100;
    }

    
    public void tick() {
        x += velX;
        y += velY;
        
        //Reverts velocity if it hits walls
        //Walls == 0 to Game.HEIGHT - 42 and 0 to Game.WIDTH - 24
        if(y <= 0 || y >= Game.HEIGHT - 42) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 24) velX *= -1;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }
    
}
