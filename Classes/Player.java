package gamedevelopment1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Timer;

public class Player extends GameObject{
    Handler handler;
    public static boolean p;
    public boolean healthRegen;
    public boolean hitRecently;
    public boolean q = true;
    private int timer = 200;
    private int timer2 = 300;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,32,32);
    }

    public void tick(){
        x+= velX;
        y+= velY;
        
        x = Game.clamp(x, 0, Game.WIDTH - 37);
        y = Game.clamp(y, 0, Game.HEIGHT - 60);
        
        if (p){
            collision();
        }
        else if (timer <= 0){
            p = true;
        }
        else{
            timer--;
        }
        
        if(!hitRecently){
            healthRegen = true;
        }
        
        if(hitRecently && timer2 <= 0){
            hitRecently = false;
        }
        else{
            timer2--;
        }
        
        if (healthRegen){
            HUD.HEALTH += 0.0125;
            }
        else{
            HUD.HEALTH += 0;
        }
    }
    
    public void PlayerHealth(){
        if(!hitRecently){
            healthRegen = true;
        }
        else{
            healthRegen = false;
        } 
        
    /*    if(hitRecently && timer2 <= 0){
            hitRecently = false;
        }
        else{
            timer2--;
        }
     */   
        if (healthRegen){
            HUD.HEALTH += 0.5;
            }
    }
    
    private void collision(){
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.TrackerEnemy || tempObject.getId() == ID.Boss1 || tempObject.getId() == ID.BigTrackerEnemy){
                if (getBounds().intersects(tempObject.getBounds())){ //tempObject = BasicEnemy
                    //collision code
                    HUD.HEALTH -= 2;
                    hitRecently = true;
                    healthRegen = false;
                    timer2 =150;
                }
            }
        }
    }

    public void render(Graphics g){

//        Graphics2D g2d = (Graphics2D) g;
//        g.setColor(Color.green);
//        g2d.draw(getBounds());
        
//        if (id == ID.Player)
          if (p){
            g.setColor(Color.white);
          }
          else{
            g.setColor(Color.yellow);
          }
//        else if (id == ID.Player2)
//            g.setColor(Color.blue);
        
        g.fillRect((int)x, (int)y, 32, 32);
    }
    
    
    
}
