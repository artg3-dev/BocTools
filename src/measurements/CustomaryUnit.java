/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package measurements;

import java.math.BigDecimal;

/**
 *
 * @author A3
 */
public enum CustomaryUnit {
    INCH(UnitDimension.LENGTH, "inch", "inches"),
    FOOT(UnitDimension.LENGTH, "foot", "feet"),
    YARD(UnitDimension.LENGTH, "yard", "yards"),
    SQ_INCH(UnitDimension.AREA, "sq. inch", "sq. inches"),
    SQ_FOOT(UnitDimension.AREA, "sq. foot", "sq. feet"),
    SQ_YARD(UnitDimension.AREA, "sq. yard", "sq. yards"),
    CU_INCH(UnitDimension.VOLUME, "cu. inch", "cu. inches"),
    CU_FOOT(UnitDimension.VOLUME, "cu. foot", "cu. feet"),
    CU_YARD(UnitDimension.VOLUME, "cu. yard", "cu. yards");

    private UnitDimension dim;
    private String singular, plural;
    CustomaryUnit(UnitDimension dim, String singular, String plural) {
        this.dim = dim;
        this.singular = singular;
        this.plural = plural;
    }

    public UnitDimension getDim() {
        return dim;
    }

    String getSingular() {
        return singular;
    }

    String getPlural() {
        return plural;
    }

    
}
