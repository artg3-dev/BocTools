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
public abstract class GabionSandwichFilter  {
    private EnumMap<Gabion, Integer> baskets;
    private static final Measurement width = new Measurement(3, 
            CustomaryUnit.FOOT);
    private ArrayList<Structure> components;

    public GabionSandwichFilter(ArrayList<Structure> components) {
        this.baskets = new EnumMap<>(Gabion.class);
        this.components = components;
    }
}
