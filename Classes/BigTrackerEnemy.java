package gamedevelopment1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BigTrackerEnemy extends GameObject {
    private Handler handler;
    private GameObject player;
    
    public BigTrackerEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        
        for (int i = 0; i < handler.object.size(); i++){
            if (handler.object.get(i).getId() == ID.Player) {
                player = handler.object.get(i);
            }
        }
     
        
    }
    
    public Rectangle getBounds(){
        return new Rectangle ((int)x,(int)y,64,64);
    }
    
    public void tick(){
        x += velX;
        y += velY;
        
        float diffX = x - player.getX() - 16;
        float diffY = y - player.getY() - 16;
        float distance = (float) Math.sqrt( (x-player.getX()) * (x-player.getX()) + (y-player.getY())*(y-player.getY()));
        
        velX =  ((-2.0f/distance)*diffX);
        velY =  ((-2.0f/distance)*diffY);
        
        if (y <= 0 || y >= Game.HEIGHT - 32)
            velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 16)
            velX *= -1;
       
        handler.addObject(new Trail((int)x,(int)y, ID.Trail, Color.green, 64, 64, 0.1f, handler));
    }
    
    public void render(Graphics g){
//        Graphics2D g2d = (Graphics2D) g;
//        g.setColor(Color.green);
//        g2d.draw(getBounds());
        
        g.setColor(Color.GREEN);
        g.fillRect((int)x,(int)y,64,64);
    }
}
