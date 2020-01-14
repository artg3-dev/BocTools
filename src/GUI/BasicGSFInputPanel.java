/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.comboboxes.FilterComboBox;
import Materials.Material;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import measurements.CustomaryUnit;
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
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        label = new JLabel("Length (ft)");
        inputLength = new JTextField();
        inputLength.setColumns(6);
        filterType = new FilterComboBox();

        add(label);
        add(inputLength);
        add(filterType);
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
            throw new IllegalArgumentException("Length must be a number");
        }
    }
}
