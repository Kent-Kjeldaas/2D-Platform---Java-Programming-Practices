package gamedevelopment1;

import static gamedevelopment1.Game.HEIGHT;
import static gamedevelopment1.Game.WIDTH;
import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    private int timer = 200;
    
    public void tick(){
        for (int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            
            tempObject.tick();
        }
    }
    
    public void render(Graphics g){
        for (int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            
            tempObject.render(g);
        }
    }
    
    public void addObject(GameObject object) {
        this.object.add(object);
    }
    
    public void clearEnemys(){
        for (int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            
            if (tempObject.getId() == ID.Player /*|| tempObject.getId() == ID.player2*/) {
                removeObject(tempObject);
                
                object.clear();
                if (Game.gameState != Game.STATE.End){
                addObject(new Player(WIDTH/2-23, HEIGHT/2-32, ID.Player, this));
                }
            }
        }
    }
    
    public void adjust(){
        for (int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            
            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy){
                tempObject.velX = tempObject.velX*0.6f;
                tempObject.velY = tempObject.velY*0.6f;
            }
            else if (tempObject.getId() == ID.TrackerEnemy || tempObject.getId() == ID.BigTrackerEnemy){
                tempObject.velX = tempObject.velX*0.3f;
                tempObject.velY = tempObject.velY*0.3f;
            }
        }
     }
    
    public void removeObject (GameObject object){
        this.object.remove(object);
    }
    
}
