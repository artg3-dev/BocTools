/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import java.util.ArrayList;
import java.util.HashMap;
import Materials.Material;
import measurements.Measurement;
import measurements.Quantity;

/**
 *
 * @author A3
 */
public abstract class Structure {

    protected final String name;
    protected final ArrayList<Material> materials;
    protected HashMap<Integer, Measurement> measurements;

    //when initializing a structure, the Measurements must be given as
    public Structure(String name, ArrayList<Material> materials) { 
        this.measurements = new HashMap();
        this.materials = materials;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Material> getMaterials() {
        return this.materials;
    }

    protected void CheckIfValidMaterial(Material m)
            throws IllegalArgumentException {
        if (!materials.contains(m)) {
            throw new IllegalArgumentException("Material " + m
                    + " is not used to construct a " + this.name);
        }
    }

    public Measurement getMeasurement(int type) throws IllegalArgumentException {
        try {
            return measurements.get(type);
        } catch (Exception e) {
            throw new IllegalArgumentException("Measurement type not valid. "
                    + "Check Measurement.CONSTANTS for options");
        }
    }

    public Measurement getMesaurement(int type) throws IllegalArgumentException {
        try {
            return measurements.get(type);

        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Given measurement type is not valid, please check "
                    + "Mesaurement.CONSTANTS for examples.");
        }
    }
    
    public void setMeasurement(int type, Measurement m) {
        try {
            measurements.put(type, m);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Given measurement type is not valid, please check "
                    + "Mesaurement.CONSTANTS for examples.");
        }
    }
    
    protected Measurement getVolume() throws IllegalArgumentException {
        try {
            return measurements.get(Measurement.LENGTH).multiply(
                    measurements.get(Measurement.WIDTH)).multiply(
                            measurements.get(Measurement.HEIGHT));
            
        } catch (Exception e) {
            throw new IllegalArgumentException("Either Length, Width, or "
                    + "Height have not been defined");
        }
    }

    public HashMap<Material, Quantity> getQuantities() {
        HashMap<Material, Quantity> qntys = new HashMap<>();
        for (Material m : materials) {
            qntys.put(m, this.getQuantity(m));
        }

        return qntys;
    }
    
    abstract public Quantity getQuantity(Material m);
}
