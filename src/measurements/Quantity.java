/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package measurements;

import Materials.Material;

/**
 *
 * @author A3
 */
public class Quantity {
    private final Material mat;
    private final Measurement measurement;
    
    public Quantity(Measurement m, Material mat) {
        this.measurement = m;
        this.mat = mat;
    }
    
    public Material getMaterial() {
        return this.mat;
    }

    @Override
    public String toString() {
        return measurement + " of " + mat.toString();
    }
    
    
    
    
}
