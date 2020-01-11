/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import Materials.Gabion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import Materials.Material;
import java.util.EnumMap;
import measurements.CustomaryUnit;
import measurements.Measurement;
import measurements.Quantity;

/**
 *
 * @author A3
 */
public class GabionSandwichFilter extends Structure {
    private EnumMap<Gabion, Integer> baskets;
    private static final Measurement width = new Measurement(3, 
            CustomaryUnit.FOOT);

    public GabionSandwichFilter(Measurement length, Measurement height) {
        super("Gabion Sandwich Filter",
                new ArrayList<Material>(Arrays.asList( 
                        Material.GABION_STONE, Material.SAND, 
                        Material.NO1_STONE, Material.WOVEN_GEO)),
                length,
                width,
                height);
        this.baskets = new EnumMap<>(Gabion.class);
        
    }

    @Override
    public Quantity getQuantity(Material m) throws IllegalArgumentException {
        CheckIfValidMaterial(m);
        
        
        return null;
    }
}
