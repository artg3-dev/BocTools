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

public class Measurement implements Convertable, Cloneable {

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

    /*
    * --Measurement Math Functions--
    *
    * All units will be converted to the unit of the instance the method was
    * called on
     */
    public Measurement add(Measurement m) throws IllegalArgumentException {
        if (this.dim != m.dim) {
            throw new IllegalArgumentException(
                    "Measurements must be of the same dimension to be added");
        }

        //converts the given measurement to the unit of this instance
        Measurement convertedM = this.getCompatable(m);

        //adds the values and returns the final sum
        double v = this.value + convertedM.value;
        return new Measurement(v, this.unit);
    }

    public Measurement subtract(Measurement m) throws IllegalArgumentException {
        if (this.dim != m.dim) {
            throw new IllegalArgumentException(
                    "Measurements must be of the same "
                            + "dimension to be subtracted");
        }

        //converts the given measurement to the unit of this instance
        Measurement convertedM = this.getCompatable(m);

        //subtracts the values and returns the final value
        double v = this.value - convertedM.value;
        return new Measurement(v, this.unit);
    }

    public Measurement multiply(Measurement m) throws IllegalArgumentException {
        // Error if either measurement is a volume
        if (this.dim == UnitDimension.VOLUME || m.dim == UnitDimension.VOLUME) {
            throw new IllegalArgumentException("Volumes cannot be multiplied "
                    + "by other measurements");
        }

        // Error if both measurements are areas
        if (this.dim == UnitDimension.AREA && m.dim == UnitDimension.AREA) {
            throw new IllegalArgumentException(
                    "Two areas cannot be multiplied");
        }

        //converts the given measurement to the unit of this instance
        Measurement convertedM = this.getCompatable(m);

        //finds the correct unit after multiplication
        CustomaryUnit u = null;
        if (this.dim == UnitDimension.LENGTH && m.dim == UnitDimension.LENGTH) {
            switch (this.unit) {
                case INCH:
                    u = CustomaryUnit.SQ_INCH;
                    break;
                case FOOT:
                    u = CustomaryUnit.SQ_FOOT;
                    break;
                case YARD:
                    u = CustomaryUnit.SQ_YARD;
                    break;
            }
        } else {
            switch (this.unit) {
                case INCH:
                case SQ_INCH:
                    u = CustomaryUnit.CU_INCH;
                    break;
                case FOOT:
                case SQ_FOOT:
                    u = CustomaryUnit.CU_FOOT;
                    break;
                case YARD:
                case SQ_YARD:
                    u = CustomaryUnit.CU_YARD;
                    break;
            }
        }

        //multiplies the values and returns the result
        double v = this.value * convertedM.value;

        return new Measurement(v, u);
    }

    public Measurement getCompatable(Measurement m)
            throws IllegalArgumentException {
        //clones m to return a new, separate measurement
        try {
            Measurement compatable = (Measurement) m.clone();
            // converts given measurement 'm' to the unit of the instance on which
            // this was called.
            if (null
                    != unit) {
                switch (unit) {
                    case INCH:
                    case SQ_INCH:
                    case CU_INCH:
                        compatable.toInches();
                        return compatable;
                    case FOOT:
                    case SQ_FOOT:
                    case CU_FOOT:
                        compatable.toFeet();
                        return compatable;
                    case YARD:
                    case SQ_YARD:
                    case CU_YARD:
                        compatable.toYards();
                        return compatable;
                    default:
                        break;

                }
            }
        } catch (CloneNotSupportedException e) {
        }
        return null;
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
