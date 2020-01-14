/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.comboboxes.FilterComboBox;
import Materials.Material;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import measurements.Measurement;
import structures.AngleGSF;
import structures.GabionSandwichFilter;

/**
 *
 * @author A3
 */
public class AngleGSFInputPanel extends JPanel implements HasGSF{

    private JCheckBox isSimple;
    private JLabel sideALabel, sideBLabel;
    private JTextField sideAInput, sideBInput;
    private FilterComboBox filterType;
    
    public AngleGSFInputPanel() {
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
        
        filterType = new FilterComboBox();
        add(filterType);
    }

    @Override
    public GabionSandwichFilter getGSF() throws IllegalArgumentException {
        if (sideAInput.getText().equals("") || 
                sideBInput.getText().equals("")) {
            throw new IllegalArgumentException("You must input both lengths");
        } 
        
        try {
            Material sandType = filterType.getMaterial();
            Measurement sideA = new Measurement(Double.parseDouble(
                    sideAInput.getText()));
            Measurement sideB = new Measurement(Double.parseDouble(
                    sideBInput.getText()));
            return new AngleGSF(sandType, sideA, sideB, new Measurement(3), 
                    isSimple.isSelected());
        } catch (Exception e) {
            throw new IllegalArgumentException("Lengths must be numbers");
        }
    }

}
