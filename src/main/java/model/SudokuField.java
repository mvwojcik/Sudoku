package model;

public class SudokuField {
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
}
