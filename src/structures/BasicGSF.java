/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import Materials.Gabion;
import Materials.Material;
import java.util.EnumMap;
import measurements.Measurement;
import measurements.Quantity;

/**
 *
 * @author A3
 */
public class BasicGSF extends GabionSandwichFilter{
    private Sandfilter filter;
    private GabionWall outterWall, innerWall;

    public BasicGSF(Material sandType, 
            Measurement length, Measurement height) {
        super(sandType);
        
        this.filter = new Sandfilter(length, height, sandType);
        this.outterWall = new GabionWall(length, height);
        this.innerWall = new GabionWall(length, height);
        
        measurements.put(Measurement.LENGTH, length);
        measurements.put(Measurement.HEIGHT, height);
        
        components.put(GabionSandwichFilter.FILTER, filter);
        components.put(GabionWall.OUTTER_WALL_A, outterWall);
        components.put(GabionWall.INNER_WALL_A, innerWall);
        
    }
}
