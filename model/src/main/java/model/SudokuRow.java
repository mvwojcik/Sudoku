package model;

import java.io.Serializable;
import java.util.List;

public class SudokuRow extends SudokuGroupBase implements Cloneable, Serializable {
    public SudokuRow() {
        super();
    }

    public SudokuRow(final List<SudokuField> sudokuFields) {
        super(sudokuFields);
    }

}
