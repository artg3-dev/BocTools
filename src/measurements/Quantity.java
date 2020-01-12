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
    
    public Measurement getMeasurement() {
        return this.measurement;
    }

    public Quantity add(Quantity q) throws IllegalArgumentException {
        if (this.mat == q.mat) {
            Measurement compatable
                    = this.measurement.getCompatable(q.measurement);
            return new Quantity(this.measurement.add(compatable), this.mat);
        }

        throw new IllegalArgumentException(
                "Cannot add quantities of different materials");
    }

    public Quantity subtract(Quantity q) throws IllegalArgumentException {
        if (this.mat == q.mat) {
            Measurement compatable
                    = this.measurement.getCompatable(q.measurement);
            return new Quantity(this.measurement.subtract(compatable), 
                    this.mat);
        }

        throw new IllegalArgumentException(
                "Cannot subtract quantities of different materials");
    }

    @Override
    public String toString() {
        return measurement + " of " + mat.toString();
    }

}
