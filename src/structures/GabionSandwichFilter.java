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
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.EnumMap;
import measurements.Measurement;
import measurements.Quantity;

/**
 *
 * @author A3
 */
public class GabionSandwichFilter extends Structure {
    private EnumMap<Gabion, Integer> baskets;

    public GabionSandwichFilter(Measurement height, Measurement length) {
        super("Gabion Sandwich Filter",
                new ArrayList<Material>(Arrays.asList( 
                        Material.GABION_STONE, Material.SAND, 
                        Material.NO1_STONE, Material.WOVEN_GEO)),
                height, 
                length);
        
    }

    @Override
    public Measurement getMeasurement(int type) {
        switch (type) {
            case HEIGHT:
                return this.measurements.get(HEIGHT);
            case WIDTH:
                return this.measurements.get(WIDTH);
        }
        return null;
    }
    
    @Override
    public Quantity getQuantity(Material m) throws IllegalArgumentException {
        CheckIfValidMaterial(m);
        
        
        return null;
    }

    @Override
    public HashMap<Material, Quantity> getQuantities() {
        
        
        return null;
    }

}
