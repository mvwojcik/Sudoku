package model;

import utils.BoardUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class SudokuBoard implements Cloneable, Serializable {

  private List<SudokuInsideList> boardAsList;

  public SudokuBoard() {
    this.boardAsList =
            Arrays.asList(new SudokuInsideList[BoardUtils.SIZE]);
    for (int i = 0; i < BoardUtils.SIZE; i++) {
      this.boardAsList.set(i, new SudokuInsideList());
    }
  }

  public final List<SudokuInsideList> getBoardAsList() {
    return boardAsList;
  }

  public final int set(final int x, final int y, final int value) {
    return this.boardAsList.get(y).set(x, value);
  }

  public final int get(final int x, final int y) {
    if ((x > BoardUtils.SIZE || x < 0) || (y > BoardUtils.SIZE || y < 0)) {
      throw new IllegalArgumentException();
    }
    return this.boardAsList.get(y).get(x); // wybieramy wiersz a potem kolumne
  }

  public final SudokuColumn getColumn(final Integer y) {
    BoardUtils.check9arg(y);
    List<SudokuField> sudokuFields =
            Arrays.asList(new SudokuField[BoardUtils.SIZE]);
    for (int i = 0; i < BoardUtils.SIZE; i++) {
      sudokuFields.set(
          i, new SudokuField(this.boardAsList
                      .get(i)
                      .getSudokuFieldList()
                      .get(y)
                      .getFieldValue()));
    }

    return new SudokuColumn(sudokuFields);
  }

  public final SudokuRow getRow(final Integer x) {
    BoardUtils.check9arg(x);

    List<SudokuField> sudokuFields =
            new ArrayList<>(this.boardAsList
                    .get(x)
                    .getSudokuFieldList());

    return new SudokuRow(sudokuFields);
  }

  // zakladamy ze x i y to poczatek boxa od lewej strony i od gory
  public final SudokuBox getBox(final int x, final int y) {
    BoardUtils.check3x3arg(x, y);

    List<SudokuField> sudokuFields =
            Arrays.asList(new SudokuField[BoardUtils.SIZE]);

    int z = 0;
    for (int i = x; i < x + BoardUtils.BOXSIZE; i++) {
      for (int j = y; j < y + BoardUtils.BOXSIZE; j++) {
        sudokuFields.set(z, new SudokuField(get(i, j)));
        System.out.print(get(i, j));
        z++;
      }
      System.out.println();
    }
    System.out.println("\n");
    return new SudokuBox(sudokuFields);
  }

  public final boolean checkBoard() {
    for (int i = 0; i < BoardUtils.SIZE; i++) {
        if (!this.getRow(i).verify() || !this.getColumn(i).verify()) {
          System.out.println("ERR HERE");
          return false;
        }
    }
    for (int i = 0; i < BoardUtils.SIZE; i += BoardUtils.BOXSIZE) {
      for (int j = 0; j < BoardUtils.SIZE; j += BoardUtils.BOXSIZE) {
        if (!this.getBox(j, i).verify()) {
          System.out.println("Err here 2");
          return false;
        }
      }
    }
    return true;
  }

  //W sumie tak jak wcześniej bylo lepiej bo te metody są depracated ale trza było zmienić
  @Override
  public final boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SudokuBoard)) {
      return false;
    }
    SudokuBoard that = (SudokuBoard) o;
    return Objects.equal(getBoardAsList(),that.getBoardAsList());
  }

  @Override
  public final int hashCode() {
    return Objects.hashCode(getBoardAsList());
  }

  public final String toString(){
    return MoreObjects.toStringHelper(this).add("BoardList",boardAsList).toString();
  }
}
