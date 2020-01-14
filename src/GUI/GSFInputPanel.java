/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import structures.GabionSandwichFilter;

/**
 *
 * @author A3
 */
public class GSFInputPanel extends JPanel {

    static final String INFO = "-Select a Type-";
    static final String BASIC = "Basic GSF";
    static final String ANGLE = "Angle GSF";
    static final String SQUARE = "Square GSF";

    private final CardLayout cl;
    private final JComboBox cb;
    private final InfoPanel info;
    private final BasicGSFInputPanel basic;
    private final AngleGSFInputPanel angle;
    private final SquareGSFInputPanel square;

    public GSFInputPanel() {
        super();
        cl = new CardLayout();
        setLayout(cl);

        info = new InfoPanel();
        add(info, INFO);
        basic = new BasicGSFInputPanel();
        add(basic, BASIC);
        angle = new AngleGSFInputPanel();
        add(angle, ANGLE);
        square = new SquareGSFInputPanel();
        add(square, SQUARE);

        String comboItems[] = {INFO, BASIC, ANGLE, SQUARE};
        cb = new JComboBox();
        cb.setEditable(false);
    }

    String[] getComboBoxItems() {
        String comboItems[] = {INFO, BASIC, ANGLE, SQUARE};
        return comboItems;
    }

    CardLayout getCardLayout() {
        return this.cl;
    }

    GabionSandwichFilter getGeneratedGSF() throws IllegalArgumentException {

        for (Component i : getComponents()) {
            if (!i.equals(info)) {
                if (i.isVisible()) {
                    HasGSF g = (HasGSF) i;
                    return g.getGSF();
                }
            }
        }
        throw new IllegalArgumentException("Select a type of GSF to generate");
    }
}
