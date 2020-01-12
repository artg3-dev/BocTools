/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.comboboxes.FilterComboBox;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author A3
 */
public class SquareGSFInputPanel extends JPanel {
    private JCheckBox isSimple;
    private JLabel sideALabel, sideBLabel, sideCLabel;
    private JTextField sideAInput, sideBInput, sideCInput;
    private FilterComboBox filterType;
    
    public SquareGSFInputPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        isSimple = new JCheckBox("Simple");
        isSimple.setSelected(true);
        add(isSimple);
        
        sideALabel = new JLabel("Side A length (ft)");
        add(sideALabel);
        
        sideAInput = new JTextField();
        sideAInput.setColumns(6);
        add(sideAInput);
        
        sideBLabel = new JLabel("Side B length (ft)");
        add(sideBLabel);
        
        sideBInput = new JTextField();
        sideBInput.setColumns(6);
        add(sideBInput);
        
        sideCLabel = new JLabel("Side C length (ft)");
        add(sideCLabel);
        
        sideCInput = new JTextField();
        sideCInput.setColumns(6);
        add(sideCInput);
        
        filterType = new FilterComboBox();
        add(filterType);
    }

}
