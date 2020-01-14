/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import structures.GabionSandwichFilter;

/**
 *
 * @author A3
 */
public class MainPanel extends JPanel implements ItemListener, ActionListener {

    private JComboBox cb;
    private GSFInputPanel gsfInput;
    private ResultsLabel gsfResults;
    private JButton button;

    public MainPanel() {
        super();
        setLayout(new GridBagLayout());
        gsfInput = new GSFInputPanel();

        cb = new JComboBox(gsfInput.getComboBoxItems());
        cb.addItemListener(this);

        gsfResults = new ResultsLabel();
        gsfResults.setVisible(false);

        button = new JButton("Generate GSF");
        button.addActionListener(this);

        addComponents();
    }

    private void addComponents() {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        
        //combobox
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(cb, c);

        //gsf input
        c.fill = GridBagConstraints.NONE;
        c.gridy = 1;
        add(gsfInput, c);

        //submit button
        c.gridy = 2;
        add(button, c);

        //results
        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 3;
        c.fill = GridBagConstraints.VERTICAL;
        add(gsfResults, c);

        //separator
        JSeparator s = new JSeparator(JSeparator.VERTICAL);
        s.setVisible(true);
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 3;
        c.fill = GridBagConstraints.VERTICAL;
        add(s, c);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        gsfInput.getCardLayout().show(gsfInput, (String) ie.getItem());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            GabionSandwichFilter gsf = gsfInput.getGeneratedGSF();
            gsfResults.update(gsf);
            gsfResults.setVisible(true);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage(), 
                    "Error Creating GSF", JOptionPane.WARNING_MESSAGE);
        }
    }

}
