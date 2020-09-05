package com.gamu.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject{
    
    private Handler handler;
        private GameObject player;

    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.Player)
                player = handler.object.get(i);
        }
        
        //SmartEnemy velocity
        velX = 5;
        velY = 5;
    }

    //Enemy hitbox
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }
    
    public void tick() {
        //Edit the number that -diffX or -diffY are divided by in order to control speed.  
        int diffX = (int)(x-player.getX() - 8);
        int diffY = (int)(y-player.getY() - 8);
        if(diffX < 0) velX = (-diffX/100 + 1);
        else if(diffX > 0) velX = (-diffX/100 - 1);
       //This else if line tells the enemy to stop moving if already in player on x axis
        else if(diffX == 0) velX = 0;
        if(diffY < 0) velY = (-diffY/100 + 1);
        else if(diffY > 0) velY = (-diffY/100 - 1);
       //This  else if line tells the enemy to stop moving if already in player on y axis
        else if(diffY == 0) velY = 0;
//        float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
        
//        velX = (int) ((-1.0/distance) * diffX);
//        velY = (int) ((-1.0/distance) * diffY);
        x += velX;
        y += velY;  
        
        //Reverts velocity if it hits walls
        //Walls == 0 to Game.HEIGHT - 42 and 0 to Game.WIDTH - 24
        if(y <= 0 || y >= Game.HEIGHT - 42) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH - 24) velX *= -1;
        
        handler.addObject(new Trail((int)x, (int)y, ID.Trail, Color.green, 16, 16, 0.02f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int)x, (int)y, 16, 16);
    }
    
}