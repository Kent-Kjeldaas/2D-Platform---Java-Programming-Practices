package gamedevelopment1;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

    private Handler handler;
    private boolean test = false;
    private boolean[] keyDown = new boolean[4];
        
    public KeyInput(Handler handler){
        this.handler = handler;
        
        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
    }
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        System.out.println(key);
        
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if (tempObject.getId() == ID.Player){
                //key events for player 1
                
                if (key == KeyEvent.VK_W) {tempObject.setVelY(-5); keyDown[0] = true;} 
                if (key == KeyEvent.VK_S) {tempObject.setVelY(+5); keyDown[1] = true;}
                if (key == KeyEvent.VK_A) {tempObject.setVelX(-5); keyDown[2] = true;} 
                if (key == KeyEvent.VK_D) {tempObject.setVelX(+5); keyDown[3] = true;} 
               
                if (key == KeyEvent.VK_1) {
                    if (Item.item1 && HUD.HEALTH<100){
                        HUD.HEALTH+=20;
                        Item.item1 = false;
                    }
                }
                if (key == KeyEvent.VK_2) {
                    if (Item.item2){
                        Player.p = false;
                        Item.item2 = false;
                    }
                }
                if (key == KeyEvent.VK_3) {
                    if (Item.item3){
                        handler.adjust();
                        Item.item3 = false;
                    }
                }
            }
//            if (tempObject.getId() == ID.Player2){
//                //key events for player 2
//                if (key == KeyEvent.VK_UP) tempObject.setVelY(-5);
//                if (key == KeyEvent.VK_DOWN) tempObject.setVelY(+5);
//                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
//                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(+5);
//            }
        }
        
        if (key == KeyEvent.VK_ESCAPE) 
            System.exit(1);
        
    }
    
    public boolean test(){
        return true;
    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if (tempObject.getId() == ID.Player){
                //key events for player 1
                
                if (key == KeyEvent.VK_W) keyDown[0] = false; //tempObject.setVelY(0);
                if (key == KeyEvent.VK_S) keyDown[1] = false; //tempObject.setVelY(0);
                if (key == KeyEvent.VK_A) keyDown[2] = false; //tempObject.setVelX(0);
                if (key == KeyEvent.VK_D) keyDown[3] = false; //tempObject.setVelX(0);
                
                //vertical moment
                if (!keyDown[0] && !keyDown[1]) tempObject.setVelY(0); 
                //horisontal moment
                if (!keyDown[2] && !keyDown[3]) tempObject.setVelX(0); 
            }
//            if (tempObject.getId() == ID.Player2){
//                if (key == KeyEvent.VK_UP) tempObject.setVelY(0);
//                if (key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
//                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
//                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
//            }
        }
    }
}
