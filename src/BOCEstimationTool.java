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

public class BOCEstimationTool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Measurement m1 = new Measurement(10, CustomaryUnit.SQ_FOOT);
        Measurement m2 = new Measurement(24, CustomaryUnit.FOOT);
        System.out.println(m1);
        System.out.println(m2);
        
        System.out.println("");
        
        Measurement result = m1.multiply(m2);
        System.out.println(result);

        
        
        

    }

}
