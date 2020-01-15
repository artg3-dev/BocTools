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

    public static final int FILTER = 0;

    protected EnumMap<Gabion, Integer> baskets;

    protected HashMap<Integer, Structure> components;

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
    
    public EnumMap<Gabion, Integer> getTotalBasketCount() {
        EnumMap<Gabion, Integer> count = new EnumMap(Gabion.class);
        count.put(Gabion.BASKET_9X3X3, 0);
        count.put(Gabion.BASKET_6X3X3, 0);

        //parses over each component
        for (int i : components.keySet()) {
            //only handles gabionwall components
            if (components.get(i).getClass() == GabionWall.class) {
                GabionWall w = (GabionWall) components.get(i);
                //adds each count to the total count "count"
                for (Gabion j : w.getBasketCount().keySet()) {
                    count.put(j, w.getBasketCount().get(j) + count.get(j));
                }
            }
        }

        return count;
    }
    
    public EnumMap<Gabion, Integer> getBasketCount(int wallType) {
        if (components.containsKey(wallType)) {
            GabionWall w = (GabionWall) components.get(wallType);
            return w.getBasketCount();
        }

        return null;
    }
    
    @Override
    public HashMap<Material, Quantity> getQuantities() {
        HashMap<Material, Quantity> qntys = new HashMap<>();

        // Parses over each component in the structure by int i (type)
        for (Integer i : components.keySet()) {
            HashMap<Material, Quantity> componentQntys
                    = components.get(i).getQuantities();

            //adds each material to the master qntys.
            for (Material j : componentQntys.keySet()) {
                if (!qntys.containsKey(j)) {
                    qntys.put(j, componentQntys.get(j));
                } else {
                    qntys.put(j, qntys.get(j).add(componentQntys.get(j)));
                }
            }
        }

        return qntys;
    }

    @Override
    public Quantity getQuantity(Material m) {
        Quantity q = null;

        //parses over each component
        for (int i : components.keySet()) {
            //if the component contains the material in question
            if (components.get(i).materials.contains(m)) {
                if (q == null) {
                    q = components.get(i).getQuantity(m);
                } else {
                    q = q.add(components.get(i).getQuantity(m));
                }
            }
        }
        if (q.getMaterial() == Material.WOVEN_GEO) {
            q.getMeasurement().toYards();
        }
        return q;
    }
}
