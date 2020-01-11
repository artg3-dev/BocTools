/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import Materials.Gabion;
import Materials.Material;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import measurements.CustomaryUnit;
import measurements.Measurement;
import measurements.Quantity;

/**
 *
 * @author A3
 */
public class GabionWall extends Structure {
    private EnumMap<Gabion, Integer> basketCount;
    private static final Measurement width = 
            new Measurement(3, CustomaryUnit.FOOT);
    
    public GabionWall(Measurement length, Measurement height) {
        super("Gabion Wall", 
                new ArrayList<Material>(Arrays.asList(Material.GABION_STONE)), 
                        length,
                        width,
                        height
                        );
        this.basketCount = Gabion.getBasketCount(length, height);
    }
    
    @Override
    public Quantity getQuantity(Material m) {
        if (materials.contains(m)) {
            Measurement v = getLength().multiply(width.multiply(getHeight()));
            v.toYards();
            return new Quantity(v, Material.GABION_STONE);
        }
        return null;
    }
    
    @Override
    public HashMap<Material, Quantity> getQuantities() {
    }
    
}
