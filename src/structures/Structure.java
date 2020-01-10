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
    protected ArrayList<Measurement> measurements;
    protected HashMap<Material, Quantity> qntys;

    public Structure(String name, ArrayList<Material> materials,
            Measurement... measurement) {
        this.measurements = new ArrayList();
        this.materials = materials;
        for (Measurement i : measurement) {
            this.measurements.add(i);
        }
        this.name = name;
        this.qntys = new HashMap();
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

    abstract public Measurement getMeasurement(int type); //i.e. (pipe length, top of basket

    abstract public Quantity getQuantity(Material m);

    abstract public HashMap<Material, Quantity> getQuantities();
}
