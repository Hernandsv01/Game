package com.gamu.main;

import com.gamu.main.Game.STATE;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
    
    private Handler handler;
    private boolean[] keyDown = new boolean[4];
    
    Game game;
    
    public KeyInput(Handler handler, Game game){
        this.handler = handler;
        
        //Fixes sticky keys bug
        keyDown[0]=false;
        keyDown[1]=false;
        keyDown[2]=false;
        keyDown[3]=false;
    }
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Player){
                //key events for player1
                if(key == KeyEvent.VK_W) { tempObject.setVelY(-5); keyDown[0]=true;}
                if(key == KeyEvent.VK_A) { tempObject.setVelX(-5); keyDown[1]=true;}
                if(key == KeyEvent.VK_S) { tempObject.setVelY(5); keyDown[2]=true;}
                if(key == KeyEvent.VK_D) { tempObject.setVelX(5); keyDown[3]=true;}
            }
//            if(tempObject.getId() == ID.Player2){
//                //key events for player2
//                if(key == KeyEvent.VK_UP) tempObject.setVelY(-5);
//                if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
//                if(key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
//                if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
//            }
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Player){
                //key events for player1
                if(key == KeyEvent.VK_W)
                    keyDown[0]=false; //tempObject.setVelY(0);
                if(key == KeyEvent.VK_A)
                    keyDown[1]=false;//tempObject.setVelX(0);
                if(key == KeyEvent.VK_S)
                    keyDown[2]=false;//tempObject.setVelY(0);
                if(key == KeyEvent.VK_D)
                    keyDown[3]=false;//tempObject.setVelX(0);
                
                
                //Vertical movement
                if(!keyDown[0] && !keyDown[2])
                    tempObject.setVelY(0);
                else if(keyDown[2] && !keyDown[0]) tempObject.setVelY(5);
                else if(!keyDown[2] && keyDown[0]) tempObject.setVelY(-5);
                
                //Horizontal movement
                if(!keyDown[1] && !keyDown[3])
                    tempObject.setVelX(0);
                else if(keyDown[3] && !keyDown[1]) tempObject.setVelX(5);
                else if(!keyDown[3] && keyDown[1]) tempObject.setVelX(-5);
                    
            }
//            if(tempObject.getId() == ID.Player2){
//                //key events for player2
//                if(key == KeyEvent.VK_UP)
//                    keyDown[0]=false; //tempObject.setVelY(0);
//                if(key == KeyEvent.VK_LEFT)
//                    keyDown[1]=false;//tempObject.setVelX(0);
//                if(key == KeyEvent.VK_DOWN)
//                    keyDown[2]=false;//tempObject.setVelY(0);
//                if(key == KeyEvent.VK_RIGHT)
//                    keyDown[3]=false;//tempObject.setVelX(0);
//                
//                //Vertical movement
//                if(!keyDown[0] && !keyDown[2])
//                    tempObject.setVelY(0);
//                else if(keyDown[2] && !keyDown[0]) tempObject.setVelY(5);
//                else if(!keyDown[2] && keyDown[0]) tempObject.setVelY(-5);
//                //Horizontal movement
//                if(!keyDown[1] && !keyDown[3])
//                    tempObject.setVelX(0);
//                else if(keyDown[3] && !keyDown[1]) tempObject.setVelX(5);
//                else if(!keyDown[3] && keyDown[1]) tempObject.setVelX(-5);
//            }
        }
        
        if(key == KeyEvent.VK_ESCAPE) System.exit(1);
        
    }
}
