/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package measurements;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 *
 * @author A3
 */
public class UnitConverter {

    public static Measurement toInches(Measurement m)
            throws IllegalArgumentException {
        //throws exception if the dimensions are not the same
        checkLength(m);

        double returnLength = m.getValue();

        switch (m.getUnit()) {
            case FOOT:
                returnLength = m.getValue() * 12;
                break;
            case YARD:
                returnLength = m.getValue() * 36;
                break;
        }

        return new Measurement(returnLength, CustomaryUnit.INCH);
    }
    public static Measurement toFeet(Measurement m)
            throws IllegalArgumentException {
        checkLength(m);

        double returnLength = m.getValue();

        switch (m.getUnit()) {
            case INCH:
                returnLength = m.getValue() / 12;
                break;
            case YARD:
                returnLength = m.getValue() * 3;
                break;
        }

        return new Measurement(returnLength, CustomaryUnit.FOOT);
    }
    public static Measurement toYards(Measurement m)
            throws IllegalArgumentException {
        checkLength(m);

        double returnLength = m.getValue();

        switch (m.getUnit()) {
            case INCH:
                returnLength = m.getValue() / 36;
                break;
            case FOOT:
                returnLength = m.getValue() / 3;
                break;
        }

        return new Measurement(returnLength, CustomaryUnit.YARD);
    }

    public static Measurement toSqInches(Measurement m)
            throws IllegalArgumentException {
        checkArea(m);

        double returnArea = m.getValue();
        switch (m.getUnit()) {
            case SQ_FOOT:
                returnArea = m.getValue() * 144;
                break;
            case SQ_YARD:
                returnArea = m.getValue() * 1296;
                break;
        }

        return new Measurement(returnArea, CustomaryUnit.SQ_INCH);
    }
    public static Measurement toSqFeet(Measurement m)
            throws IllegalArgumentException {
        checkArea(m);

        double returnArea = m.getValue();
        switch (m.getUnit()) {
            case SQ_INCH:
                returnArea = m.getValue() / 144;
                break;
            case SQ_YARD:
                returnArea = m.getValue() * 9;
                break;
        }

        return new Measurement(returnArea, CustomaryUnit.SQ_FOOT);
    }
    public static Measurement toSqYards(Measurement m)
            throws IllegalArgumentException {
        checkArea(m);

        double returnArea = m.getValue();
        switch (m.getUnit()) {
            case SQ_INCH:
                returnArea = m.getValue() / 1296;
                break;
            case SQ_FOOT:
                returnArea = m.getValue() / 9;
                break;
        }

        return new Measurement(returnArea, CustomaryUnit.SQ_YARD);
    }
    
    public static Measurement toCubicInches(Measurement m)
            throws IllegalArgumentException {
        checkVolume(m);
        
        double returnVolume = m.getValue();
        switch (m.getUnit()) {
            case CU_FOOT:
                returnVolume = m.getValue() * 1728;
                break;
            case CU_YARD:
                returnVolume = m.getValue() * 46656;
                break;
        }
        
        return new Measurement(returnVolume, CustomaryUnit.CU_INCH);
    }
    public static Measurement toCubicFeet(Measurement m)
            throws IllegalArgumentException {
        checkVolume(m);
        
        double returnVolume = m.getValue();
        switch (m.getUnit()) {
            case CU_INCH:
                returnVolume = m.getValue() / 1728;
                break;
            case CU_YARD:
                returnVolume = m.getValue() * 27;
                break;
        }
        
        return new Measurement(returnVolume, CustomaryUnit.CU_FOOT);
    }
    public static Measurement toCubicYards(Measurement m)
            throws IllegalArgumentException {
        checkVolume(m);
        
        double returnVolume = m.getValue();
        switch (m.getUnit()) {
            case CU_INCH:
                returnVolume = m.getValue() / 46656;
                break;
            case CU_FOOT:
                returnVolume = m.getValue() / 27;
                break;
        }
        
        return new Measurement(returnVolume, CustomaryUnit.CU_YARD);
    }

    private static void checkLength(Measurement m)
            throws IllegalArgumentException {
        if (m.getUnit().getDim() != UnitDimension.LENGTH) {
            throw new IllegalArgumentException("Cannot convert between dimensions");
        }
    }
    private static void checkArea(Measurement m)
            throws IllegalArgumentException {
        if (m.getUnit().getDim() != UnitDimension.AREA) {
            throw new IllegalArgumentException("Cannot convert between dimensions");
        }
    }
    private static void checkVolume(Measurement m)
            throws IllegalArgumentException {
        if (m.getUnit().getDim() != UnitDimension.VOLUME) {
            throw new IllegalArgumentException("Cannot convert between dimensions");
        }
    }
}
