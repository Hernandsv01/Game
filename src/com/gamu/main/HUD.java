package com.gamu.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
    
    public static float HEALTH = 100;
    public float greenValue = 255;
    
    private int score = 0;
    private int level = 1;
    
    public void tick(){
        HEALTH = Game.clamp(HEALTH, 0, 100);
        
        //Changes color of health bar as it goes down
        greenValue = Game.clamp(greenValue, 0, 255);
        greenValue = HEALTH*2;
        
        score++;
    }
    
    public void render(Graphics g){
        //Shows health bar
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.getHSBColor( (1f * HEALTH) / 360, 1f, 1f));
//        g.setColor(new Color(75, greenValue, 0)); is the basic form of fade
        g.fillRect(15, 15, (int)(HEALTH*2), 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, (int)(HEALTH*2), 32);
        g.drawString(HEALTH+"%", 15, 15);
        
        //Shows score and level
        g.drawString("Score: " + score, 10, 64);
        g.drawString("Level: " + level, 10, 80);
    }
    
    public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return score;
    }
    
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level = level;
    }
}
