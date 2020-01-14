/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.comboboxes.FilterComboBox;
import Materials.Material;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import measurements.Measurement;
import structures.BasicGSF;
import structures.GabionSandwichFilter;

/**
 *
 * @author A3
 */
public class BasicGSFInputPanel extends JPanel implements HasGSF {

    private JLabel label;
    private JTextField inputLength;
    private FilterComboBox filterType;

    public BasicGSFInputPanel() {
        super();
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        label = new JLabel("Length (ft)");
        inputLength = new JTextField();
        inputLength.setColumns(6);
        filterType = new FilterComboBox();
        
        //label
        c.gridx = 0;
        c.gridy = 1;
        add(label, c);
        
        //input
        c.gridx = 1;
        c.gridy = 1;
        add(inputLength, c);
        
        //combobox
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        add(filterType, c);
    }

    @Override
    public GabionSandwichFilter getGSF() throws IllegalArgumentException {
        if (inputLength.getText().equals("")) {
            throw new IllegalArgumentException("You must input a length");
        }
        try {
            Material sandType = filterType.getMaterial();
            Measurement length = new Measurement(Double.parseDouble(
                    inputLength.getText()));
            return new BasicGSF(sandType, length, new Measurement(3));
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Length must be a number divisible by 3");
        }
    }
}
