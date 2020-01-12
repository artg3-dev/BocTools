/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import Materials.Gabion;
import java.util.HashMap;
import Materials.Material;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import measurements.CustomaryUnit;
import measurements.Measurement;
import measurements.Quantity;

/**
 *
 * @author A3
 */
public abstract class GabionSandwichFilter extends Structure {

    public static int FILTER = 0;
    public static int OUTTER_WALL_A = 1;
    public static int OUTTER_WALL_B = 2;
    public static int OUTTER_WALL_C = 3;
    public static int INNER_WALL_A = 4;
    public static int INNER_WALL_B = 5;
    public static int INNER_WALL_C = 6;

    private EnumMap<Gabion, Integer> baskets;
    private static final Measurement width = new Measurement(3,
            CustomaryUnit.FOOT);
    private HashMap<Integer, Structure> components;

    public GabionSandwichFilter(Material sandType) {
        super("Gabion sandwich filter", new ArrayList<Material>(Arrays.asList(
                Material.GABION_STONE,
                sandType,
                Material.NO1_STONE,
                Material.WOVEN_GEO)));
        this.baskets = new EnumMap<>(Gabion.class);
        this.components = new HashMap();
    }

    public Structure getComponent(int type) {
        if (components.containsKey(type)) {
            return components.get(type);
        }

        return null;
    }

    @Override
    public HashMap<Material, Quantity> getQuantities() {
        HashMap<Material, Quantity> qntys = new HashMap<>();

        // Parses over each component in the structure by int i (type)
        for (Integer i : components.keySet()) {
            HashMap<Material, Quantity> componentQntys = 
                    components.get(i).getQuantities();

            //adds each material to the master qntys.
            for (Material j : componentQntys.keySet()) {
                if (!qntys.containsKey(j)) {
                    qntys.put(j, componentQntys.get(j));
                } else{
                    qntys.put(j, qntys.get(j).add(componentQntys.get(j)));
                }
            }
        }
        
        return qntys;
    }

    abstract public EnumMap<Gabion, Integer> getTotalBasketCount();

    abstract public EnumMap<Gabion, Integer> getBasketCount(GabionWall g);
}
