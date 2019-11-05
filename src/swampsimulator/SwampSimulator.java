package swampsimulator;
import javax.swing.*;

/**
 * @author dougthebicyclist
 */
public class SwampSimulator extends JFrame {
    public SwampSimulator() {
        super("Swamp Simulator");
        setSize(1280, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Login login = new Login();
    }
    ;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        SwampSimulator swampsimluatormain = new SwampSimulator();
        
        }
    
}
