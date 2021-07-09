import javax.swing.*;

import java.awt.*;
import cs101.sosgame.SOS;
/**
 * Sos game panel class
 * @author Hazal Buluş
 * @version 1.0 09.07.2021 
 */

public class SOSCanvas extends JPanel
{
      
    //Properties
    public final int SIDE_LENGTH = 400;
    SOS game;
    static int gridCellNumber;         
    static int sideOfBox; 
      
    //Constructor
    public SOSCanvas(SOS game)
    {
        this.game = game;
        setPreferredSize(new Dimension(SIDE_LENGTH +1, SIDE_LENGTH +1));
        gridCellNumber = game.getDimension();
        sideOfBox = SIDE_LENGTH / gridCellNumber;
        setBackground(Color.WHITE);
            
        repaint();
    }

    //Methods
    @Override
    public void paintComponent(Graphics g){
      
        super.paintComponent(g);            
        g.setColor(Color.BLACK);
            
        int x = 0;
        int y = 0;
            
        for(int i = 0; i < (int)gridCellNumber; i++ ){
            x  = 0;
                  
            for(int j = 0; j < (int)gridCellNumber; j++ ){
                        
                
                g.drawLine((int) x, (int) y, (int) x, SIDE_LENGTH);
                g.drawLine((int) x, (int) y, SIDE_LENGTH, (int) y);  
                       
                x +=sideOfBox;
            }
            y +=sideOfBox;
        }
        
        g.drawLine(SIDE_LENGTH, 0, SIDE_LENGTH, SIDE_LENGTH);        
        g.drawLine(0, SIDE_LENGTH, SIDE_LENGTH, SIDE_LENGTH);

        x = sideOfBox / 2;
        y = sideOfBox / 2;
        for(int i = 0; i < (int)gridCellNumber; i++ ){
            x = sideOfBox / 2;
                  
            for(int j = 0; j < (int)gridCellNumber; j++ ){
                        
                g.drawString(game.getCellContents(j, i) + "", x, y);
                       
                x +=sideOfBox;
            }
            y +=sideOfBox;
        }
        
    } 
   
      
    public double getSideOfBox(){
      
        return sideOfBox;
    }
}
