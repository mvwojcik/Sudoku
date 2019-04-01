package model;


import java.util.Objects;

public class SudokuField{
    Integer value;

    public SudokuField() {
    }

    public SudokuField(final Integer value) {
        this.value = value;
    }

    public Integer getFieldValue() {
        return value;
    }

    public void setFieldValue(final Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SudokuField)) return false;
        SudokuField that = (SudokuField) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
