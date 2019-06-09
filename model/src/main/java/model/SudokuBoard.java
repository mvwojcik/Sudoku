package model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import exceptions.FieldException;
import exceptions.GroupException;
import exceptions.VerificationException;
import pl.mwkc.utils.BoardUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuBoard implements Cloneable, Serializable {

    private List<SudokuInsideList> boardAsList;

    public SudokuBoard() {
        this.boardAsList = Arrays.asList(new SudokuInsideList[BoardUtils.SIZE]);
        for (int i = 0; i < BoardUtils.SIZE; i++) {
            this.boardAsList.set(i, new SudokuInsideList());
        }
    }

    public SudokuBoard(List<SudokuInsideList> boardAsList) {
        this.boardAsList = boardAsList;
    }

    public final int set(final int x, final int y, final int value) {
        return this.boardAsList.get(y).set(x, value);
    }

    public final int get(final int x, final int y) throws FieldException {
        if ((x > BoardUtils.SIZE || x < 0) || (y > BoardUtils.SIZE || y < 0)) {
            throw new FieldException("error.argument",new IllegalArgumentException(""));
        }
        return this.boardAsList.get(y).get(x);
    }

    public final SudokuColumn getColumn(final Integer y) {
        BoardUtils.check9arg(y);
        List<SudokuField> sudokuFields = Arrays.asList(new SudokuField[BoardUtils.SIZE]);
        for (int i = 0; i < BoardUtils.SIZE; i++) {
            sudokuFields.set(
                    i, new SudokuField(this.boardAsList.get(i).getSudokuFieldList().get(y).getFieldValue()));
        }

        return new SudokuColumn(sudokuFields);
    }

    public final SudokuRow getRow(final Integer x) {
        BoardUtils.check9arg(x);

        List<SudokuField> sudokuFields = new ArrayList<>(this.boardAsList.get(x).getSudokuFieldList());

        return new SudokuRow(sudokuFields);
    }

    public final SudokuBox getBox(final int x, final int y) throws GroupException {
        BoardUtils.check3x3arg(x, y);

        List<SudokuField> sudokuFields = Arrays.asList(new SudokuField[BoardUtils.SIZE]);

        int z = 0;
        for (int i = x; i < x + BoardUtils.BOXSIZE; i++) {
            for (int j = y; j < y + BoardUtils.BOXSIZE; j++) {
                try {
                    sudokuFields.set(z, new SudokuField(get(i, j)));
                } catch (FieldException e) {
                    throw new GroupException("",e);
                }
                z++;
            }
        }
        return new SudokuBox(sudokuFields);
    }

    public final boolean checkBoard() throws VerificationException, GroupException {
        for (int i = 0; i < BoardUtils.SIZE; i++) {
            if (!this.getRow(i).verify() || !this.getColumn(i).verify()) {
                if (!this.getRow(i).verify()) {
                    throw new VerificationException("error.rowsVerification");
                } else {
                    throw new VerificationException("error.columnsVerification");
                }
            }
        }

        for (int i = 0; i < BoardUtils.SIZE; i += BoardUtils.BOXSIZE) {
            for (int j = 0; j < BoardUtils.SIZE; j += BoardUtils.BOXSIZE) {
                if (!this.getBox(j, i).verify()) {
                    throw new VerificationException("error.boxesVerification");
                }
            }
        }
        return true;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof SudokuBoard)) {
            return false;
        }
        SudokuBoard that = (SudokuBoard) o;
        return Objects.equal(this.boardAsList, that.boardAsList);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(this.boardAsList);
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add("BoardList", boardAsList).toString();
    }

    @Override
    public SudokuBoard clone() {
        List<SudokuInsideList> board = new ArrayList<>(9);

        for (int i = 0; i < 9; i++) {
            SudokuInsideList board2 = new SudokuInsideList();
            for (int j = 0; j < 9; j++) {
                board2.set(j,
                        this.boardAsList.get(i).get(j));
            }
            board.add(board2);
        }
        return new SudokuBoard(board);
    }
}
