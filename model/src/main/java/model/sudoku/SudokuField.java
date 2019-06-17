package model.sudoku;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

public class SudokuField implements Cloneable, Serializable,
        Comparable<SudokuField> {
    private Integer value;

    public SudokuField() {
        this.value = new Integer(0);
    }

    public SudokuField(final Integer valueOfField) {
        this.value = valueOfField;
    }

    public final Integer getFieldValue() {
        return value;
    }

    public final void setFieldValue(final Integer valueOfField) {
        this.value = valueOfField;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SudokuField)) {
            return false;
        }
        SudokuField that = (SudokuField) o;
        return Objects.equal(that.value, this.value);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public final String toString() {
        return MoreObjects.
                toStringHelper(this).add("val: ", value).toString();
    }

    @Override
    public final int compareTo(final SudokuField o) {
        return Integer.
                compare(this.value, o.getFieldValue());
    }

    @Override
    public final SudokuField clone() {
        try {
            return (SudokuField) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }

    }
}
