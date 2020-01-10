/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materials;

/**
 *
 * @author A3
 */
public enum Material {
    GABION_STONE("Gabion stone"),
    NO1_STONE("No. 1 stone"),
    SAND("Sand"),
    WOVEN_GEO("Woven Geotextile");
        
    private final String name;

    private Material(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    

    
}
