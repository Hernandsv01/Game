package com.gamu.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
    //All game objects extend this abstract class
    
    //Location
    protected float x, y;
    
    //ID to recognize type of object
    protected ID id;
    
    //Velocity of object which is then added to position
    protected float velX, velY;
    
    public GameObject(float x, float y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    //Collision, returns true if rectangles touching
    public abstract Rectangle getBounds();
    
    //Setters to change variables
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setId(ID id){
        this.id = id;
    }
    public void setVelX(int velX) {
        this.velX = velX;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }
    
    //Getters to obtain the value of the variables
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public ID getId(){
        return id;
    }
    public float getVelX() {
        return velX;
    }
    public float getVelY() {
        return velY;
    }
}
