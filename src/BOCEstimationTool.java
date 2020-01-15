/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A3
 */
import GUI.BOCToolsGUI;
import javax.swing.SwingUtilities;

public class BOCEstimationTool {
    public static final String VERSION = "v0.3-alpha";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BOCToolsGUI gui = new BOCToolsGUI();
        SwingUtilities.invokeLater(gui);
    }
}
