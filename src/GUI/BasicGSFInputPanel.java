/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.comboboxes.FilterComboBox;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author A3
 */
public class BasicGSFInputPanel extends JPanel {
    private JLabel label;
    private JTextField inputLength;
    private FilterComboBox filterType;
    
    public BasicGSFInputPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        label = new JLabel("Length (ft)");
        inputLength = new JTextField();
        inputLength.setColumns(6);
        filterType = new FilterComboBox();
        
        add(label);
        add(inputLength);
        add(filterType);
    }
}
