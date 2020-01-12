/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import Materials.Material;
import measurements.Measurement;

/**
 *
 * @author A3
 */
public class AngleGSF extends GabionSandwichFilter{
    private boolean isSimple;
    private Sandfilter filter;
    private GabionWall owA;
    private GabionWall owB;
    private GabionWall iwA;
    private GabionWall iwB;
    
    
    public AngleGSF(Material sandType, Measurement outsideA, 
            Measurement outsideB, Measurement height, boolean isSimple) {
        super(sandType);
        
        this.isSimple = isSimple;
        
        if (isSimple) {
            owA = new GabionWall(outsideA, height);
            owB = new GabionWall(outsideB.subtract(new Measurement(3)), height);
            iwA = new GabionWall(outsideA.subtract(new Measurement(3)), height);
            iwB = new GabionWall(outsideB.subtract(new Measurement(6)), height);
            Measurement filterLength = new Measurement(outsideA.getValue() + 
                    outsideB.getValue() - 7.5);
            filter = new Sandfilter(filterLength, height, sandType);
            
        } else {
            owA = new GabionWall(outsideA, height);
            owB = new GabionWall(outsideB, height);
            iwA = new GabionWall(outsideA.subtract(new Measurement(3)), height);
            iwB = new GabionWall(outsideB.subtract(new Measurement(3)), height);
            Measurement filterLength = new Measurement(outsideA.getValue() + 
                    outsideB.getValue() - 7.5);
            filter = new Sandfilter(filterLength, height, sandType);
        }
       
        measurements.put(Measurement.LENGTH, outsideA.add(outsideB));
        measurements.put(Measurement.HEIGHT, height);
        
        components.put(GabionSandwichFilter.FILTER, filter);
        components.put(GabionWall.OUTTER_WALL_A, owA);
        components.put(GabionWall.INNER_WALL_A, iwA);
        components.put(GabionWall.OUTTER_WALL_B, owB);
        components.put(GabionWall.INNER_WALL_B, iwB);
    }
    
}
