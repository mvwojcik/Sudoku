package model;

import java.util.Objects;

public class SudokuField {
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
    return value.equals(that.value);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(value);
  }
}
