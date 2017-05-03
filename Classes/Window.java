package gamedevelopment1;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{
    private static final long serialVersionUID = -2L;
    
    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title); //Created JFrame, "our window"
        
        frame.setPreferredSize(new Dimension(width, height)); 
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //let the X-button actually work ^^
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); //opens JFrame in the middle of our computer-window, else it spawns in the upperleft.
        frame.add(game);
        frame.setVisible(true);
        game.start();
        
    }
}
