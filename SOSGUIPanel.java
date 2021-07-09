import javax.swing.*;

import java.awt.*;
import cs101.sosgame.SOS;
import java.awt.event.*;
/**
 * Sos game GUI panel class
 * @author Hazal Buluş
 * @version 1.0 09.07.2021 
 */

public class SOSGUIPanel extends JPanel{

    //properties
      
    SOSCanvas sosCanvas;
    JPanel scorePanel;
    JPanel buttonPanel;
    JLabel p1;
    JLabel p2;
    JLabel d;
    JRadioButton sButton;
    JRadioButton oButton;
    SOS sosGame;
    String player1;
    String player2;
    JComboBox<String> comboBox;
    String[] letters = {".", "S", "O"};
    String text;

     
    //Constructor
    public SOSGUIPanel(SOS sosGame, String player1, String player2)
    {
           
        this.sosGame = sosGame;
        this.player1 = player1;
        this.player2 = player2;
        setLayout(new BorderLayout());

        scorePanel = new JPanel();
        scorePanel.setPreferredSize(new Dimension(400, 30)); 
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(400, 50));
           
        p1 = new JLabel(player1 + ":  " + sosGame.getPlayerScore1());
        d = new JLabel("  -  ");
        p2 = new JLabel(player2 + ":  " + sosGame.getPlayerScore2());

        p1.setOpaque(true);
        p2.setOpaque(true);
        p1.setForeground(Color.green);
           
        comboBox = new JComboBox<>(letters);

        scorePanel.add(p1);
        scorePanel.add(d);
        scorePanel.add(p2);
        buttonPanel.add(comboBox);
           
        sosCanvas = new SOSCanvas(sosGame);
        sosCanvas.addMouseListener(new CanvasListener());
        comboBox.addActionListener(new ComboBoxListener());
           
        setPreferredSize(new Dimension(800, 800));
        add(sosCanvas, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        add(scorePanel, BorderLayout.NORTH);
    }
     
    private class CanvasListener extends MouseAdapter{
           
        public void mousePressed(MouseEvent e) 
        {
                 
            Point p = e.getPoint();
            double x = p.getX();
            double y = p.getY();
                 
            double sideOfBox = sosCanvas.getSideOfBox();
                 
            int row = (int) (y / (int) sideOfBox) +1;
            int column = (int) (x / (int) sideOfBox) +1;
                 
            if(text.equals("s"))
            {
                sosGame.play('s', column, row);

                p1.setText(player1 + ":  " + sosGame.getPlayerScore1());
                p2.setText(player2 + ":  " + sosGame.getPlayerScore2());
                       
            }
            else if(text.equals("o"))
            {
                sosGame.play('o', column, row);

                p1.setText(player1 + ":  " + sosGame.getPlayerScore1());
                p2.setText(player2 + ":  " + sosGame.getPlayerScore2());
            }
                                  
            if(sosGame.getTurn() == 1)
            {
                p1.setForeground(Color.green);
                p2.setForeground(Color.black);
            }
            else if(sosGame.getTurn()== 2)
            {
                p2.setForeground(Color.green);
                p1.setForeground(Color.BLACK);
            }
                 
            repaint();
                 
            if(sosGame.isGameOver()){
                       
                String message;

                if(sosGame.getPlayerScore1() > sosGame.getPlayerScore2())
                {
                    message = player1 + " wins the game!" ; 
                }
                else if(sosGame.getPlayerScore1() < sosGame.getPlayerScore2())
                {
                    message = player2 + " wins the game!"; 
                }
                else 
                {
                    message = "It is a draw!";
                }
                       
                JOptionPane.showConfirmDialog(sosCanvas, message , "Game Over", JOptionPane.DEFAULT_OPTION);
            }
        }
    } 
     
    private class ComboBoxListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if(comboBox.getSelectedIndex() == 1)
            {
                text = "s";     
            }
            else if(comboBox.getSelectedIndex() == 2)
            {
                text = "o";
            }
        }
    }
}
