package java.boardtests;

import algorithms.BackTrackingSudokuSolver;
import algorithms.SudokuSolver;
import model.SudokuBoard;
import org.junit.jupiter.api.Test;
import persistence.dao.Dao;
import persistence.dao.SudokuBoardDaoFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DaoTest {

    @Test
    public void init() {
        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuSolver sudokuSolver = new BackTrackingSudokuSolver();
        sudokuSolver.solve(sudokuBoard);



        try (Dao dao = SudokuBoardDaoFactory.getFileDao("cieciu.txt")){

            dao.write(sudokuBoard);

        } catch(IOException e){
        //    System.out.println(e.getMessage());
        }
        catch (Exception e) {
        //    System.out.println(e.getMessage());
        }

        try (Dao dao = SudokuBoardDaoFactory.getFileDao("cieciu.txt")){

            sudokuBoard = (SudokuBoard)dao.read();

        } catch(IOException e){
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertTrue(sudokuBoard.checkBoard());

    }

}
