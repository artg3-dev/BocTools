/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.comboboxes;

import Materials.Material;
import javax.swing.JComboBox;

/**
 *
 * @author A3
 */
public class FilterComboBox extends JComboBox {

    public FilterComboBox() {
        super();
        addItem(Material.SAND.toString());
        addItem(Material.SAND_MULCH.toString());
        setMaximumRowCount(this.getItemCount());
    }

}
