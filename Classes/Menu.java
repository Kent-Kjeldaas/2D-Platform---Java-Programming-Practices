package gamedevelopment1;

import static gamedevelopment1.Game.HEIGHT;
import gamedevelopment1.Game.STATE;
import static gamedevelopment1.Game.WIDTH;
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
    private int topScore;
    private int money;
    private int moneySpent;
    public boolean x;
    private Random r = new Random();
    
    public Menu (Game game, Handler handler, HUD hud){
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }
    
    public boolean x(boolean x){
        if (x){
            return false;
        }
        else {
            return true;
        }
    }
    
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        
        //play button
        if (game.gameState == STATE.Menu){
        if (mouseOver(mx, my, 210, 150, 200, 64)){
            hud.setLevel(1);
            hud.setScore(0);
            if(!Item.item2)
            Player.p = true;
            topScore = 0;
            game.gameState = STATE.Game;
            handler.addObject(new Player(WIDTH/2-23, HEIGHT/2-32, ID.Player, handler));
            handler.clearEnemys();
//             for (int i = 0; i < 10; i++)
             handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
//           handler.addObject(new Player(WIDTH/2+64, HEIGHT/2-32, ID.Player2, handler));
        }
        }
        
        //help button
        if (game.gameState == STATE.Menu){
        if (mouseOver(mx, my, 210, 250, 200, 64)){
            game.gameState = STATE.Help;
        }
        }
        
        //back button (for help)
        
        if (game.gameState == STATE.Help) {
            if (mouseOver(mx, my, 210, 350, 200, 64)){
                game.gameState = STATE.Menu;
                return;
            }
        }
        
        //quit button
        if (game.gameState == STATE.Menu){
        if (mouseOver(mx, my, 210, 350, 200, 64)){
            System.exit(0);
        }
        }
        
        //Buttons for END
        
        if (game.gameState == STATE.End) {
            if (hud.getScore() > topScore){
                topScore = hud.getScore();
            }
            money = topScore - moneySpent;
            
            if (mouseOver(mx, my, 75, 300, 150, 32)){
                hud.setLevel(1);
                hud.setScore(0);
                game.gameState = STATE.Game;
                handler.addObject(new Player(WIDTH/2-23, HEIGHT/2-32, ID.Player, handler));
                handler.clearEnemys();
//              for (int i = 0; i < 10; i++)
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
//                    handler.addObject(new Player(WIDTH/2+64, HEIGHT/2-32, ID.Player2, handler));
        }
            
            if (mouseOver(mx, my, 250, 300, 150, 32)){
                game.gameState = STATE.Item;
                return;
            }
            
            if (mouseOver(mx, my, 425, 300, 150, 32)){
                game.gameState = STATE.Menu;
                return;
            }
        }
        
        //Buttons for ITEMS
        if (game.gameState == STATE.Item) {
            if (mouseOver(mx, my, 75, 300, 150, 32)){
                if (money >= 300 && x(Item.item1)){
                    money-=300;
                    moneySpent += 300;
                    Item.item1 = true;
                    System.out.println("Health potion bought");
                }
                
            }
            
            if (mouseOver(mx, my, 250, 300, 150, 32)){
                if (money >= 300 && x(Item.item2)){
                    money-=300;
                    moneySpent += 300;
                    Item.item2 = true;
                    System.out.println("Zhonya's active");
                }
            }
            
            if (mouseOver(mx, my, 425, 300, 150, 32)){
                if (money >= 300 && x(Item.item3)){
                    money-=300;
                    moneySpent += 300;
                    Item.item3 = true;
                    System.out.println("Slow potion bought");
                }
            }
            
            if (mouseOver(mx, my, 425, 180, 150, 32)){
                hud.setLevel(1);
                hud.setScore(0);
                game.gameState = STATE.Game;
                handler.addObject(new Player(WIDTH/2-23, HEIGHT/2-32, ID.Player, handler));
                handler.clearEnemys();
//              for (int i = 0; i < 10; i++)
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
//                    handler.addObject(new Player(WIDTH/2+64, HEIGHT/2-32, ID.Player2, handler));
        }
        }
    }
    
    public void mouseReleased(MouseEvent e){
        
    }
    
    public void tick(){
        
    }
    
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if (mx > x && mx < x + width){
            if (my > y && my <y + height){
                return true;
            }
            else return false;
        }
        else return false;
    }
    
    public void render(Graphics g){
        //MENU
        if (game.gameState == STATE.Menu){
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);
        
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Menu", 270, 90);
        
        g.setFont(fnt2);
        g.drawRect(210, 150, 200, 64);
        g.drawString("Play", 250, 200);
        
        g.setColor(Color.white);
        g.drawRect(210, 150, 200, 64);
        
        g.setFont(fnt2);
        g.drawRect(210, 250, 200, 64);
        g.drawString("Help", 250, 300);
        
        g.setColor(Color.white);
        g.drawRect(210, 250, 200, 64);
        
        g.setFont(fnt2);
        g.drawRect(210, 350, 200, 64);
        g.drawString("Quit", 250, 400);
        
        g.setColor(Color.white);
        g.drawRect(210, 350, 200, 64);
        }
        
        //HELP
        else if (game.gameState == STATE.Help){
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);
        Font fnt3 = new Font("arial", 1, 20);
        
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Help", 270, 90);
        
        g.setFont(fnt3);
        g.drawString("Use WASD keys to move player and dodge enemies", 50, 140);
        g.drawString("Press 1 to use MinorPotion (most be bought first)", 50, 180);
        g.drawString("Press 2 to use Zhonya's (most be bought first)", 50, 220);
        g.drawString("Press 3 to use Slow Potion (most be bought first)", 50, 260);
        
        g.setFont(fnt2);
        g.drawRect(210, 350, 200, 64);
        g.drawString("Back", 250, 400);
        }
        
        //DEAD
        else if (game.gameState == STATE.End){
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);
        Font fnt3 = new Font("arial", 1, 20);
        
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("You Died.", 190, 90);
        
        g.setFont(fnt3);
        g.drawString("You lost with a score of: " + hud.getScore(), 175, 200);
        g.drawString("On level: " + hud.getLevel(), 175, 250);
        
        g.setFont(fnt3);
        g.drawRect(75, 300, 150, 32);
        g.drawString("Continue", 110, 325);
        
        g.setFont(fnt3);
        g.drawRect(250, 300, 150, 32);
        g.drawString("Item Upgrades", 255, 325);
        
        g.setFont(fnt3);
        g.drawRect(425, 300, 150, 32);
        g.drawString("Back to Menu", 435, 325);
        }
        
        //ITEMS
        else if (game.gameState == STATE.Item){
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);
        Font fnt3 = new Font("arial", 1, 20);
        Font fnt4 = new Font("arial", 1, 15);
        
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("ITEMS!", 190, 90);
        
        g.setFont(fnt3);
        g.setColor(Color.green);
        g.drawString("Money: " + money, 90, 200);
        
        g.setFont(fnt4);
        g.setColor(Color.white);
        g.drawString("Cost for Consumables: 300", 75, 290);
        
        g.setFont(fnt2);
        g.drawRect(425, 180, 150, 32);
        g.drawString("Continue", 435, 208);
        
        g.setColor(Color.white);
        g.setFont(fnt3);
        g.drawRect(75, 300, 150, 32);
        if (Item.item1){
            g.setColor(Color.GRAY);
            g.drawString("Item bought!", 90, 325);
        }
        else{
            g.setColor(Color.white);
            g.drawString("MinorPotion", 90, 325);
        }
        
        g.setColor(Color.white);
        g.setFont(fnt3);
        g.drawRect(250, 300, 150, 32);
        if (Item.item2){
            g.setColor(Color.GRAY);
            g.drawString("Item bought!", 255, 325);
        }
        else {
            g.setColor(Color.white);
            g.drawString("Zhonya's", 255, 325);
        }
        
        g.setColor(Color.white);
        g.setFont(fnt3);
        g.drawRect(425, 300, 150, 32);
        if (Item.item3){
            g.setColor(Color.GRAY);
            g.drawString("Item bought!", 435, 325);
        }
        else {
            g.setColor(Color.white);
            g.drawString("Slow potion", 435, 325);
        }
        
        g.setFont(fnt4);
        g.setColor(Color.white);
        g.drawString("Cost for permanent items: 3000", 75, 360);
        
        g.setColor(Color.white);
        g.setFont(fnt3);
        g.drawRect(75, 375, 150, 32);
        if (Item.item4){
            g.setColor(Color.GRAY);
            g.drawString("Item bought!", 85, 400);
        }
        else {
            g.setColor(Color.white);
            g.drawString("Not Unlocked", 85, 400);
        }
        
        g.setColor(Color.white);
        g.setFont(fnt3);
        g.drawRect(250, 375, 150, 32);
        if (Item.item5){
            g.setColor(Color.GRAY);
            g.drawString("Item bought!", 265, 400);
        }
        else {
            g.setColor(Color.white);
            g.drawString("Not Unlocked", 265, 400);
        }
        
        g.setColor(Color.white);
        g.setFont(fnt3);
        g.drawRect(425, 375, 150, 32);
        if (Item.item6){
            g.setColor(Color.GRAY);
            g.drawString("Item bought!", 435, 400);
        }
        else {
            g.setColor(Color.white);
            g.drawString("Not Unlocked", 435, 400);
        }
        }
    }
}


//Health regen (slow) (can buy item to make it faster)
//Hydra Boss (kills, him spawns 3 new) don't fucking kill him
//Boss 2, sends tracker-enemy
// Gun-item unlock after lvl 10