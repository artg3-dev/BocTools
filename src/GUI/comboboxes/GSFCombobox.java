/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.comboboxes;

import javax.swing.JComboBox;

/**
 *
 * @author A3
 */
public class GSFCombobox extends JComboBox {

    public GSFCombobox() {
        super();
        this.addItem("-Select GSF Style-");
        this.addItem("Basic GSF");
        this.addItem("Angled GSF, Simple");
        this.addItem("Angled GSF, Complex");
        this.addItem("Square GSF, Simple");
        this.addItem("Square GSF, Complex");
        this.setMaximumRowCount(this.getItemCount());
    }
}
