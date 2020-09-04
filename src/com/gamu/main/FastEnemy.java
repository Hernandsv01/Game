package com.gamu.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject{
    
    private Handler handler;

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        //FastEnemy velocity
        velX = 2;
        velY = 15;
    }

    //Enemy hitbox
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }
    
    public void tick() {
        x += velX;
        y += velY;
        
        //Reverts velocity if it hits walls
        //Walls == 0 to Game.HEIGHT - 42 and 0 to Game.WIDTH - 24
        if(y <= 0 || y >= Game.HEIGHT - 42) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 24) velX *= -1;
        
        handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.cyan, 16, 16, 0.02f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect((int)x, (int)y, 16, 16);
    }
    
}
