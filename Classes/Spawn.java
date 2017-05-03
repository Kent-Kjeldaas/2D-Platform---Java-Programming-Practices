package gamedevelopment1;

import java.util.Random;

public class Spawn {
    
    private Handler handler;
    private HUD hud;
    private Random r = new Random ();
    
    private int scoreKeep = 0;
    
    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }
    
    public void tick(){
        scoreKeep++;
        
        if (scoreKeep>=500 && hud.getLevel() <= 9 || scoreKeep>=2000 && hud.getLevel() == 10 || scoreKeep>=500 && hud.getLevel() <= 19){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel()+1);
            
            if (hud.getLevel() == 2)
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
            
            if (hud.getLevel() == 3)
                handler.addObject(new TrackerEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.TrackerEnemy, handler));
           
            if (hud.getLevel() == 4)
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
            
            if (hud.getLevel() == 5)
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
            
            if (hud.getLevel() == 6)
                handler.addObject(new TrackerEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.TrackerEnemy, handler));
           
            if (hud.getLevel() == 7)
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
            
            if (hud.getLevel() == 8)
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
            
            if (hud.getLevel() == 9)
                handler.addObject(new TrackerEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.TrackerEnemy, handler));
            
            if (hud.getLevel() == 10) {
                handler.clearEnemys();
                handler.addObject(new Boss1((Game.WIDTH/2)-48, -120, ID.Boss1, handler));
            }
            if (hud.getLevel() == 11) {
                handler.clearEnemys();
                handler.addObject(new BigTrackerEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BigTrackerEnemy, handler));
            }
            if (hud.getLevel() == 12) {
                handler.addObject(new BigTrackerEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BigTrackerEnemy, handler));
            }
        }
    }
    
}
