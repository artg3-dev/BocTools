/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package measurements;

/**
 *
 * @author A3
 */
public class Measurement implements Convertable {

    private double value;
    private CustomaryUnit unit;
    private final UnitDimension dim;

    public Measurement(double value, CustomaryUnit unit) {
        this.value = value;
        this.unit = unit;
        this.dim = unit.getDim();
    }

    public CustomaryUnit getUnit() {
        return unit;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (value == 1) {
            return value + " " + unit.getSingular();
        } else {
            return value + " " + unit.getPlural();
        }
    }

    @Override
    public void toInches() {
        switch (dim) {
            case LENGTH:
                this.value = UnitConverter.toInches(this).getValue();
                this.unit = UnitConverter.toInches(this).getUnit();
                break;
            case AREA:
                this.value = UnitConverter.toSqInches(this).getValue();
                this.unit = UnitConverter.toSqInches(this).getUnit();
                break;
            case VOLUME:
                this.value = UnitConverter.toCubicInches(this).getValue();
                this.unit = UnitConverter.toCubicInches(this).getUnit();
                break;
        }
    }

    @Override
    public void toFeet() {
        switch (dim) {
            case LENGTH:
                this.value = UnitConverter.toFeet(this).getValue();
                this.unit = UnitConverter.toFeet(this).getUnit();
                break;
            case AREA:
                this.value = UnitConverter.toSqFeet(this).getValue();
                this.unit = UnitConverter.toSqFeet(this).getUnit();
                break;
            case VOLUME:
                this.value = UnitConverter.toCubicFeet(this).getValue();
                this.unit = UnitConverter.toCubicFeet(this).getUnit();
                break;
        }
    }

    @Override
    public void toYards() {
        switch (dim) {
            case LENGTH:
                this.value = UnitConverter.toYards(this).getValue();
                this.unit = UnitConverter.toYards(this).getUnit();
                break;
            case AREA:
                this.value = UnitConverter.toSqYards(this).getValue();
                this.unit = UnitConverter.toSqYards(this).getUnit();
                break;
            case VOLUME:
                this.value = UnitConverter.toCubicYards(this).getValue();
                this.unit = UnitConverter.toCubicYards(this).getUnit();
                break;
        }
    }

}
