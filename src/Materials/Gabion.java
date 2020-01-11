/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Materials;

import java.util.EnumMap;
import measurements.CustomaryUnit;
import measurements.Measurement;
import measurements.UnitDimension;

/**
 *
 * @author A3
 */
public enum Gabion {
    BASKET_9X3X3("9'x3'x3' basket", 9, 3, 3),
    BASKET_6X3X3("6'x3'x3' basket", 6, 3, 3);

    private String name;
    private Measurement length;
    private Measurement width;
    private Measurement height;

    private Gabion(String name, double length, double width, double height) {
        this.name = name;
        this.length = new Measurement(length, CustomaryUnit.FOOT);
        this.width = new Measurement(width, CustomaryUnit.FOOT);
        this.height = new Measurement(height, CustomaryUnit.FOOT);
    }

    public Measurement getVolume() {
        return new Measurement(length.getValue()
                * width.getValue()
                * height.getValue(), CustomaryUnit.CU_FOOT);
    }

    public static EnumMap<Gabion, Integer> getBasketCount(Measurement mLength)
            throws IllegalArgumentException {

        //checks for illegal unit dimension and converts to feet
        if (mLength.getUnit().getDim() != UnitDimension.LENGTH) {
            throw new IllegalArgumentException("Measurement must be a length");
        } else {
            mLength.toFeet();
        }

        //checks for illegal length
        if ((mLength.getValue() % 3) != 0 || mLength.getValue() < 6) {
            throw new IllegalArgumentException(
                    "Lengths must be at least 6 and divisible by 3");
        }
        int iLength = (int) mLength.getValue();

        //parses basket count
        int count9, count6;
        EnumMap<Gabion, Integer> basketCount = new EnumMap(Gabion.class);

        switch (iLength % 9) {
            case 0:
                count6 = 0;
                count9 = (int) iLength / 9;
                basketCount.put(BASKET_6X3X3, count6);
                basketCount.put(BASKET_9X3X3, count9);
                return basketCount;

            case 3:
                count6 = 2;
                iLength -= 12;
                if (iLength == 0) {
                    count9 = 0;
                } else {
                    count9 = (int) iLength / 9;
                }
                basketCount.put(BASKET_6X3X3, count6);
                basketCount.put(BASKET_9X3X3, count9);
                return basketCount;

            case 6:
                count6 = 1;
                iLength -= 6;
                if (iLength == 0) {
                    count9 = 0;
                } else {
                    count9 = (int) iLength / 9;
                }
                basketCount.put(BASKET_6X3X3, count6);
                basketCount.put(BASKET_9X3X3, count9);
                return basketCount;
        }
        return null;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
