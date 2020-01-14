/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author A3
 */
public class BOCToolsGUI implements Runnable{
    private JFrame frame;
    public BOCToolsGUI() {
    }
    
    @Override
    public void run() {
        frame = new JFrame("BOC Estimation Tool");
        frame.setPreferredSize(new Dimension(600, 300));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MainPanel());
        frame.pack();
        frame.setVisible(true);
    }
    
}
