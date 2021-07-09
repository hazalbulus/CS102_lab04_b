import javax.swing.*;
import cs101.sosgame.SOS;
/**
 * Sos game main class
 * @author Hazal Buluş
 * @version 1.0 09.07.2021 
 */

public class SOSGame {
      
    public static void main(String[] args){

        final int WIDTH = 416;
        final int HEIGHT = 518;
            
        SOS sosgame =new SOS(4);
        String player1 = "Player1";
        String player2 = "Player2";

        SOSGUIPanel canvas = new SOSGUIPanel(sosgame, player1, player2);
        JFrame frame = new JFrame ("Welcome to SOS Game!!");
            
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);            
        frame.pack();
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }
      
}