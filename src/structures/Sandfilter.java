/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import Materials.Material;
import java.util.ArrayList;
import java.util.Arrays;
import measurements.CustomaryUnit;
import measurements.Measurement;
import measurements.Quantity;

/**
 *
 * @author A3
 */
public class Sandfilter extends Structure{
    public Sandfilter(Measurement length, Measurement gabionHeight, 
            Material type) {
        super("Sand filter", 
                new ArrayList<Material>(Arrays.asList(type, Material.NO1_STONE, 
                        Material.WOVEN_GEO)));
        measurements.put(Measurement.LENGTH, length);
        measurements.put(Measurement.WIDTH, new Measurement(1.5, 
                CustomaryUnit.FOOT));
        measurements.put(Measurement.HEIGHT, gabionHeight.subtract(
                        new Measurement(0.5, CustomaryUnit.FOOT)));
        
    }
    
    @Override
    public Quantity getQuantity(Material m) {
        // Sand or sand/mulch
        if (m == materials.get(0)) {
            Measurement v = getVolume();
            v.toYards();
            return new Quantity(v, m);
        }
        
        // No. 1 Stone
        if (m == materials.get(1)) {
            Measurement v = measurements.get(Measurement.LENGTH).multiply(
                    measurements.get(Measurement.WIDTH).multiply(
                            new Measurement(0.5, CustomaryUnit.FOOT)));
            v.toYards();
            return new Quantity(v, m);
        }
        
        // Geotextile
        if (m == materials.get(2)) {
            Measurement v = measurements.get(Measurement.LENGTH).multiply(
                    new Measurement(12.5, CustomaryUnit.FOOT));
            v.toFeet();
            return new Quantity(v, m);
        }
        
        return null;
    }
    
}
