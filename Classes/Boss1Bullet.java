package gamedevelopment1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss1Bullet extends GameObject{
    
    private Handler handler;
    Random r = new Random();

    public Boss1Bullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        
        velX = (r.nextInt(5 - -5) + -5);
        velY = 5;
        
    }
    
    public Rectangle getBounds(){
        return new Rectangle ((int)x,(int)y,16,16);
    }
    
    public void tick(){
        x += velX;
        y += velY;
        
//        if (y <= 0 || y >= Game.HEIGHT - 32)
//            velY *= -1;
//        if (x <= 0 || x >= Game.WIDTH - 16)
//            velX *= -1;
        if (y >= Game.HEIGHT) handler.removeObject(this);
       
        handler.addObject(new Trail((int)x,(int)y, ID.Trail, Color.red, 16, 16, 0.1f, handler));
    }
    
    public void render(Graphics g){
//        Graphics2D g2d = (Graphics2D) g;
//        g.setColor(Color.green);
//        g2d.draw(getBounds());
        
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y,16,16);
    }
}
