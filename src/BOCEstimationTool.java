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
        // TODO code application logic here
//        Measurement m = new Measurement(12, CustomaryUnit.INCH);
//        Measurement m2 = new Measurement(144, CustomaryUnit.SQ_INCH);
//        Measurement m3 = new Measurement(1728, CustomaryUnit.CU_INCH);
//
//        
//        System.out.println("------Begin------");
//        System.out.println(m);
//        System.out.println(m2);
//        System.out.println(m3);
//
//        System.out.println("------Inch------");
//        m.toInches();
//        m2.toInches();
//        m3.toInches();
//
//        System.out.println(m);
//        System.out.println(m2);
//        System.out.println(m3);
//
//        System.out.println("------Foot------");
//        m.toFeet();
//        m2.toFeet();
//        m3.toFeet();
//
//        System.out.println(m);
//        System.out.println(m2);
//        System.out.println(m3);
//
//        System.out.println("------Yard------");
//        m.toYards();
//        m2.toYards();
//        m3.toYards();
//
//        System.out.println(m);
//        System.out.println(m2);
//        System.out.println(m3);
//        
//        System.out.println("------Quantity------");
        Measurement m = new Measurement(45, CustomaryUnit.FOOT);
        try {
            System.out.println(m);
            System.out.println(Gabion.getBasketCount(m));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

}
