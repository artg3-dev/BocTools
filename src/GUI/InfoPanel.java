/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author A3
 */
public class InfoPanel extends JPanel{
    private final String info = "Simple: "
            + "A GSF that is a straight line\n" 
            + "Angle: A GSF that has two arms\n"
            + "Box: A GSF that has two arms and a front face\n"
            + "\n"
            + "Simple: All angles in the GSF are 90 degrees, "
            + "and baskets are not nested during construction\n"
            + "Non-Simple: Angles differ from 90 degrees, "
            + "and baskets are nested at intersections during construction";
    public InfoPanel() {
        super();
        JTextArea textArea = new JTextArea(info);
        add(textArea);
    }
    
}
