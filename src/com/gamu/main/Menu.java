package com.gamu.main;

import com.gamu.main.Game.STATE;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter{
    
    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    
    public Menu(Game game, Handler handler, HUD hud){
        this.game = game;
        this.hud = hud;
        this.handler = handler;
    }
    
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        
        if(game.gameState == STATE.Menu){
            //Play button
            if(mouseOver(mx, my, 210, 150, 200, 64)){
                AudioPlayer.stopMusic();
                AudioPlayer.playGameSound();
                game.gameState = STATE.Game;

                //Here the objects are created
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
                handler.clearEnemies();
//              handler.addObject(new Player(WIDTH/2+64, HEIGHT/2-32, ID.Player2));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                
            }

            //Help button
            if(mouseOver(mx, my, 210, 250, 200, 64)){
                game.gameState = STATE.Help;
            }
            //Quit button
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                System.exit(1);
            }
        }
        
        
        //Back button for help
        if(game.gameState == STATE.Help){
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                game.gameState = STATE.Menu;
                return;
            }
        }
        
        //Try again button
        if(game.gameState == STATE.End){
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                AudioPlayer.stopMusic();
                AudioPlayer.playGameSound();
                game.gameState = STATE.Game;
                hud.setScore(0);
                hud.setLevel(1);
                handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
                handler.clearEnemies();
//              handler.addObject(new Player(WIDTH/2+64, HEIGHT/2-32, ID.Player2));
                
            }
        }
        
    }
    
    public void mouseReleased(MouseEvent e){
        
    }
    
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            } else return false;
        } else return false;
    }
    
    public void tick(){
        
    }
    public void render(Graphics g){
        if(Game.gameState == STATE.Menu){
            Font fnt = new Font("Arial", 1, 50);
            Font fnt2 = new Font("Arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 240, 70);

            g.setFont(fnt2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 270, 190);

            g.drawRect(210, 250, 200, 64);
            g.drawString("Help", 270, 290);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 270, 390);
            
        }else if(game.gameState == STATE.Help){
            Font fnt = new Font("Arial", 1, 50);
            Font fnt2 = new Font("Arial", 1, 30);
            Font fnt3 = new Font("Arial", 1, 20);
            
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 240, 70);
            
            g.setFont(fnt3);
            g.drawString("Use WASD keys to move the player and dodge enemies", 50, 200);
            
            g.setFont(fnt2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Back", 270, 390);
        }else if(game.gameState == STATE.End){
            Font fnt = new Font("Arial", 1, 50);
            Font fnt2 = new Font("Arial", 1, 30);
            Font fnt3 = new Font("Arial", 1, 20);
            
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Game over", 180, 70);
            
            g.setFont(fnt3);
            g.drawString("You lost with a score of: " + hud.getScore(), 175, 200);
            
            g.setFont(fnt2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Try again", 245, 390);
        }
        
    }
}
