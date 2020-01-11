/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A3
 */
import Materials.Gabion;
import measurements.CustomaryUnit;
import Materials.Material;
import measurements.Measurement;
import measurements.Quantity;
import structures.Sandfilter;

public class BOCEstimationTool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Measurement m1 = new Measurement(10, CustomaryUnit.FOOT);
        Measurement m2 = new Measurement(3, CustomaryUnit.FOOT);

        Sandfilter s = new Sandfilter(m1, m2, Material.SAND);
        for (Material i : s.getMaterials()) {
            System.out.println(s.getQuantity(i));
        }
        
        

    }

}
