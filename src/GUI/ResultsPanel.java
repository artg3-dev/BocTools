/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Materials.Gabion;
import Materials.Material;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import structures.GabionSandwichFilter;

/**
 *
 * @author A3
 */
public class ResultsPanel extends JPanel {

    private GabionSandwichFilter gsf;
    private JLabel gStoneLabel, sandLabel, nStoneLabel, geoLabel,
            sixLabel, nineLabel;
    private JLabel gStoneAmt, sandAmt, nStoneAmt, geoAmt,
            sixAmt, nineAmt;

    public ResultsPanel() {
        super();
        setVisible(true);
        setLayout(new GridBagLayout());
        GridBagConstraints c;
        Insets inset = new Insets(0, 10, 0, 0);

        gStoneLabel = new JLabel("Gabion Stone:");
        Font bold = gStoneLabel.getFont().deriveFont(Font.BOLD, 15f);
        gStoneLabel.setFont(bold);
        c = new GridBagConstraints();
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        add(gStoneLabel, c);

        gStoneAmt = new JLabel();
        c = new GridBagConstraints();
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = inset;
        add(gStoneAmt, c);

        sandLabel = new JLabel("Sand:");
        sandLabel.setFont(bold);
        c = new GridBagConstraints();
        c.weighty = 1;
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 0;
        c.gridy = 1;
        add(sandLabel, c);

        sandAmt = new JLabel();
        c = new GridBagConstraints();
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = inset;
        add(sandAmt, c);

        nStoneLabel = new JLabel("No. 1 Stone:");
        nStoneLabel.setFont(bold);
        c = new GridBagConstraints();
        c.weighty = 1;
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 0;
        c.gridy = 2;
        add(nStoneLabel, c);

        nStoneAmt = new JLabel();
        c = new GridBagConstraints();
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = inset;
        add(nStoneAmt, c);

        geoLabel = new JLabel("Woven Geo:");
        geoLabel.setFont(bold);
        c = new GridBagConstraints();
        c.weighty = 1;
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 0;
        c.gridy = 3;
        add(geoLabel, c);

        geoAmt = new JLabel();
        c = new GridBagConstraints();
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 3;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = inset;
        add(geoAmt, c);

        //separator
        JSeparator s = new JSeparator(SwingConstants.HORIZONTAL);
        s.setVisible(true);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        add(s, c);

        sixLabel = new JLabel(Gabion.BASKET_6X3X3.toString() + "s:");
        sixLabel.setFont(bold);
        c = new GridBagConstraints();
        c.weighty = 1;
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 0;
        c.gridy = 5;
        add(sixLabel, c);

        sixAmt = new JLabel();
        c = new GridBagConstraints();
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 5;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = inset;
        add(sixAmt, c);

        nineLabel = new JLabel(Gabion.BASKET_9X3X3.toString() + "s:");
        nineLabel.setFont(bold);
        c = new GridBagConstraints();
        c.weighty = 1;
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 0;
        c.gridy = 6;
        add(nineLabel, c);

        nineAmt = new JLabel();
        c = new GridBagConstraints();
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 6;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = inset;
        add(nineAmt, c);
    }

    public void update(GabionSandwichFilter g) {
        gStoneAmt.setText(g.getQuantity(Material.GABION_STONE).getMeasurement()
                .toTons());
        if (g.getSandType() == Material.SAND) {
            sandLabel.setText(Material.SAND.toString() + ":");
            sandAmt.setText(g.getQuantity(Material.SAND).getMeasurement()
                    .toTons());
        } else {
            sandLabel.setText(Material.SAND_MULCH.toString() + ":");
            sandAmt.setText(g.getQuantity(Material.SAND_MULCH).getMeasurement()
                    .toString());
        }
        nStoneAmt.setText(g.getQuantity(Material.NO1_STONE)
                .getMeasurement().toTons());
        geoAmt.setText(g.getQuantity(Material.WOVEN_GEO)
                .getMeasurement().toString());
        sixAmt.setText("" + g.getTotalBasketCount()
                .get(Gabion.BASKET_6X3X3));
        nineAmt.setText("" + g.getTotalBasketCount()
                .get(Gabion.BASKET_9X3X3));
    }

}
