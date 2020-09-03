package com.gamu.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{
    
    Random r = new Random();
    Handler handler;
    
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }
    
    //Player hitbox
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
    
    public void tick() {
        //Adds the velocity to the current position
        x += velX;
        y += velY;
        
        x = Game.clamp(x, 0, Game.WIDTH - 38);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);
        
        collision();
    }
    
    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                //Collision code
                HUD.HEALTH -= 2;
                }
            }
        }
    }

    public void render(Graphics g) {
        //Color of Player 1
        if(id == ID.Player) g.setColor(Color.blue);
        //Color of Player 2
//        else if(id == ID.Player2) g.setColor(Color.red);
        //Fills the Player with respective color
        g.fillRect(x, y, 32, 32);
    }
}
