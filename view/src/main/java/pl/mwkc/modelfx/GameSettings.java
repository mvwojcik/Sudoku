package pl.mwkc.modelfx;

import model.SudokuBoard;

import java.util.Random;

public enum GameSettings {
  easy{
          public SudokuBoard handle(SudokuBoard sudokuBoard) {
              return handleLevel(sudokuBoard, 2);
    }
  },
  intermediate{
      public SudokuBoard handle(SudokuBoard sudokuBoard) {
          return handleLevel(sudokuBoard, 6);
      }
  },
  hard() {
      public SudokuBoard handle(SudokuBoard sudokuBoard) {
          return handleLevel(sudokuBoard,10);
      }
  };
private static GameSettings level;

    public static GameSettings getLevel() {
        return level;
    }

    public static void setLevel(GameSettings level) {
        GameSettings.level = level;
    }

    public static GameSettings getLevels(int level) {
      switch (level) {
          case 0: return easy;
          case 1: return intermediate;
          default: return hard;
      }
  }
  private static SudokuBoard handleLevel(final SudokuBoard sudokuBoard, int x) {
    SudokuBoard sudokuBoardCopy = sudokuBoard.clone();
    System.out.println(sudokuBoard.equals(sudokuBoardCopy));
    System.out.println(sudokuBoard == sudokuBoardCopy);
    Random random = new Random();
    random.nextInt(9);
    sudokuBoardCopy.set(3, 3, 0);
    return sudokuBoardCopy;
  }
}
