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
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import measurements.Measurement;
import structures.GabionSandwichFilter;
import structures.SquareGSF;

/**
 *
 * @author A3
 */
public class SquareGSFInputPanel extends JPanel implements HasGSF {

    private JCheckBox isSimple;
    private JLabel sideALabel, sideBLabel, sideCLabel;
    private JTextField sideAInput, sideBInput, sideCInput;
    private FilterComboBox filterType;

    public SquareGSFInputPanel() {
        super();
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(2, 2, 2, 2);
        //isSimple checkbox
        c.gridx = 0;
        c.gridy = 0;
        isSimple = new JCheckBox("Simple");
        isSimple.setSelected(true);
        add(isSimple, c);

        //sideA label
        c.gridx = 0;
        c.gridy = 2;
        sideALabel = new JLabel("Side A length (ft)");
        add(sideALabel, c);

        //sideA input
        c.gridx = 1;
        c.gridy = 2;
        sideAInput = new JTextField();
        sideAInput.setColumns(6);
        add(sideAInput, c);

        //sideB label
        c.gridx = 0;
        c.gridy = 3;
        sideBLabel = new JLabel("Side B length (ft)");
        add(sideBLabel, c);

        //sideB input
        c.gridx = 1;
        c.gridy = 3;
        sideBInput = new JTextField();
        sideBInput.setColumns(6);
        add(sideBInput, c);
        
        //sideC label
        c.gridx = 0;
        c.gridy = 4;
        sideCLabel = new JLabel("Side C length (ft)");
        add(sideCLabel, c);
        
        //sideC input
        c.gridx = 1;
        c.gridy = 4;
        sideCInput = new JTextField();
        sideCInput.setColumns(6);
        add(sideCInput, c);

        //combobox
        c.gridx = 1;
        c.gridy = 0;
        filterType = new FilterComboBox();
        add(filterType, c);

//        isSimple = new JCheckBox("Simple");
//        isSimple.setSelected(true);
//        add(isSimple);
//
//        sideALabel = new JLabel("Side A length (ft)");
//        add(sideALabel);
//
//        sideAInput = new JTextField();
//        sideAInput.setColumns(6);
//        add(sideAInput);
//
//        sideBLabel = new JLabel("Side B length (ft)");
//        add(sideBLabel);
//
//        sideBInput = new JTextField();
//        sideBInput.setColumns(6);
//        add(sideBInput);
//
//        sideCLabel = new JLabel("Side C length (ft)");
//        add(sideCLabel);
//
//        sideCInput = new JTextField();
//        sideCInput.setColumns(6);
//        add(sideCInput);
//
//        filterType = new FilterComboBox();
//        add(filterType);
    }

    @Override
    public GabionSandwichFilter getGSF() throws IllegalArgumentException {
        if (sideAInput.getText().equals("")
                || sideBInput.getText().equals("")
                || sideCInput.getText().equals("")) {
            throw new IllegalArgumentException("You must input all lengths");
        }

        try {
            Material sandType = filterType.getMaterial();
            Measurement sideA = new Measurement(Double.parseDouble(
                    sideAInput.getText()));
            Measurement sideB = new Measurement(Double.parseDouble(
                    sideBInput.getText()));
            Measurement sideC = new Measurement(Double.parseDouble(
                    sideCInput.getText()));

            return new SquareGSF(sandType, sideA, sideB, sideC,
                    new Measurement(3), isSimple.isSelected());
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(
                    "Lengths must be numbers divisible by 3");
        }
    }

}
