package swampsimulator;
import javax.swing.*;

/**
 * @author dougthebicyclist
 */
public class SwampSimulator extends JFrame {
    private Login loginPanel;
    private JFrame frame;
    
    public void initialize() {
        frame = new JFrame("Swamp Simulator");
        loginPanel = new Login(this);
        
        //frame.add(startPanel);
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(loginPanel);
        frame.validate();
        frame.pack();
    };

public static void main(String args[]) throws InterruptedException {
      
        SwampSimulator swampsim = new SwampSimulator();        
        swampsim.initialize();
        // TODO code application logic here
        
        // this would be the shit connected to the "checkout" button
        JFrame frame = new JFrame("me swamp");
        
        Game game = new Game();
        
        frame.add(game);
        frame.setSize(1280, 720);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while (true){
            game.move();
            game.repaint();
            Thread.sleep(10);

        }
    }

}
