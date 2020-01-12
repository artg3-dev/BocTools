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

    public static final int OUTTER_WALL_A = 41;
    public static final int OUTTER_WALL_B = 42;
    public static final int OUTTER_WALL_C = 43;
    public static final int INNER_WALL_A = 44;
    public static final int INNER_WALL_B = 45;
    public static final int INNER_WALL_C = 46;
    
    
    private EnumMap<Gabion, Integer> basketCount;
    private static final Measurement width
            = new Measurement(3, CustomaryUnit.FOOT);

    public GabionWall(Measurement length, Measurement height) {
        super("Gabion Wall",
                new ArrayList<Material>(Arrays.asList(Material.GABION_STONE,
                        Material.WOVEN_GEO)));
        measurements.put(Measurement.LENGTH, length);
        measurements.put(Measurement.WIDTH, width);
        measurements.put(Measurement.HEIGHT, height);

        this.basketCount = Gabion.getBasketCount(length, height);
    }
    
    protected EnumMap<Gabion, Integer> getBasketCount() {
        return this.basketCount;
    }

    @Override
    public Quantity getQuantity(Material m) {
        if (m == Material.GABION_STONE) {
            Measurement v = measurements.get(Measurement.LENGTH).multiply(
                    width.multiply(measurements.get(Measurement.HEIGHT)));
            v.toYards();
            return new Quantity(v, Material.GABION_STONE);
        } else if (m == Material.WOVEN_GEO) {
            Measurement a = measurements.get(Measurement.LENGTH).multiply(
                    new Measurement(12.5));
            return new Quantity(a, Material.WOVEN_GEO);
        }
        return null;
    }
}
