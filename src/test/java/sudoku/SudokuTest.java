package sudoku;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by seth on 11/22/16.
 */
public class SudokuTest {
    @Test
    public void sudokuParser() throws Exception {
        String[] validChars = {"1", "2", "3", "4"};
        String[][] board = {{"4","2","-","1"},{"-","-","-","2"},{"3","-","2","-"},{"-","4","-","3"}};

        Sudoku sudoku = new Sudoku();
        sudoku.SudokuParser("src/main/resources/SamplePuzzles/Input/solvable.txt");

        assertEquals(4, sudoku.size);
        assertArrayEquals(validChars, sudoku.validChars);
        assertArrayEquals(board, sudoku.board);

        board = new String[][]{{"2", "-", "3", "1"}, {"1", null, null, null}, {null}, {null}};
        sudoku.SudokuParser("src/main/resources/SamplePuzzles/Input/falseBoard.txt");

        assertEquals(4, sudoku.size);
        assertArrayEquals(validChars, sudoku.validChars);

        assert board[0][0].equals(sudoku.board[0][0]);
        assert board[0][1].equals(sudoku.board[0][1]);
        assert board[0][2].equals(sudoku.board[0][2]);
        assert board[0][3].equals(sudoku.board[0][3]);

        assert board[1][0].equals(sudoku.board[1][0]);
        assert board[1][1] == sudoku.board[1][1];
        assert board[1][1] == sudoku.board[1][1];
        assert board[1][2] == sudoku.board[1][2];
        assert board[1][3] == sudoku.board[1][3];

        assert board[2][0] == sudoku.board[2][0];

        assert board[3][0] == sudoku.board[3][0];

        Arrays.asList(board).indexOf("1");
    }
}