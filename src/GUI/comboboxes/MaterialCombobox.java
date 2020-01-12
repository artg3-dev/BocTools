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
public class MaterialCombobox extends JComboBox {

    public MaterialCombobox() {
        super();
        this.addItem("-Select Material-");
        for (Material i : Material.values()) {
            this.addItem(i.toString());
        }
        this.setMaximumRowCount(this.getItemCount());
    }

}
