package boardtests;

import model.SudokuBoard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeSet;

public class BoardGeneratorTest {

  SudokuBoard sudokuBoard1;
  SudokuBoard sudokuBoard2;

  @Before
  public void initBoards() {
    this.sudokuBoard1 = new SudokuBoard();
    this.sudokuBoard2 = new SudokuBoard();
    sudokuBoard1.fillBoard();
    sudokuBoard2.fillBoard();
  }

  @Test
  public void check3() {
    SudokuBoard sudokuBoard = new SudokuBoard();
    sudokuBoard.fillBoard();
    for (int z = 0; z < 3; z++) {
      for (int k = 0; k < 3; k++) {
        for (int i = k * 3; i < 3 * k + 3; i++) {
          TreeSet<Integer> values = new TreeSet<Integer>();
          for (int j = z * 3; j < 3 * z + 3; j++) {
            System.out.print(sudokuBoard.getBoard()[i][j]);
            Assert.assertTrue(values.add(sudokuBoard.getBoard()[i][j]));
          }
          System.out.println();
        }
        System.out.println("\n");
      }
    }
  }

  @Test
  public void checkRandomBoardsGeneration() {
    Assert.assertFalse(sudokuBoard1 == sudokuBoard2);
    Assert.assertFalse(sudokuBoard1.equals(sudokuBoard2));
  }

  @Test
  public void checkrows() {
    for (int i = 0; i < 9; i++) {
      TreeSet<Integer> values = new TreeSet<Integer>();
      for (int j = 0; j < 9; j++) {
        Assert.assertTrue(values.add(sudokuBoard1.getBoard()[i][j]));
        Assert.assertFalse(values.add(sudokuBoard1.getBoard()[i][j]));
      }
    }
  }

  @Test
  public void checkColumns() {
    for (int i = 0; i < 9; i++) {
      TreeSet<Integer> values = new TreeSet<Integer>();
      for (int j = 0; j < 9; j++) {
        Assert.assertTrue(values.add(sudokuBoard1.getBoard()[j][i]));
        Assert.assertFalse(values.add(sudokuBoard1.getBoard()[j][i]));
      }
    }
  }
}
