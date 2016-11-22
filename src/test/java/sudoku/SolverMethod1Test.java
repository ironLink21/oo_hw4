package sudoku;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * Created by seth on 11/21/16.
 */
public class SolverMethod1Test {

    @Test
    public void findEmptyCell() throws Exception {
        String[] validChars = {"1", "2", "3", "4"};
        String[][] board = {{"4","2","-","1"},{"-","-","-","2"},{"3","-","2","-"},{"-","4","-","3"}};
        String[][] board_expected = {{"4","2","1,2,3,4","1"},{"1,2,3,4","1,2,3,4","1,2,3,4","2"},{"3","1,2,3,4","2","1,2,3,4"},{"1,2,3,4","4","1,2,3,4","3"}};

        SolverMethod1 solver = new SolverMethod1(board, validChars);

        solver.findEmptyCell();
        assertEquals(solver.emptyCoordinates.size(), 8);

        assertArrayEquals(board_expected, board);

        String[][] board1 = {};
        solver = new SolverMethod1(board1, validChars);

        solver.findEmptyCell();
        assertEquals(solver.emptyCoordinates.size(), 0);
    }

    @Test
    public void checkRow() throws Exception {
        String[] validChars = {"1", "2", "3", "4"};
        String[][] board = {{"4","2","-","1"},{"-","-","-","2"},{"3","-","2","-"},{"-","4","-","3"}};

        SolverMethod1 solver = new SolverMethod1(board, validChars);

        solver.findEmptyCell();
        solver.checkRow();
        int[] test = {0,2};
        int[] test2 = solver.emptyCoordinates.poll();
        assertArrayEquals(test2, test);

        board = new String[][]{{"4", "2", "-", "1"}, {"-", "-", "-", "2"}, {"3", "-", "2", "-"}, {"-", "4", "-", "3"}};
        String[][] board_expected = {{"4","2","3","1"},{"1,3,4","1,3,4","1,3,4","2"},{"3","1,4","2","1,4"},{"1,2","4","1,2","3"}};
        solver = new SolverMethod1(board, validChars);

        solver.findEmptyCell();
        solver.checkRow();

        assertArrayEquals(board_expected, board);
    }

    @Test
    public void checkCol() throws Exception {
        String[] validChars = {"1", "2", "3", "4"};
        String[][] board = {{"4","2","-","1"},{"-","-","-","2"},{"3","-","2","-"},{"-","4","-","3"}};
        String[][] board_expected = {{"4","2","3","1"},{"1","1,3","1,4","2"},{"3","1","2","4"},{"1,2","4","1,2","3"}};

        SolverMethod1 solver = new SolverMethod1(board, validChars);

        solver.findEmptyCell();
        solver.checkRow();
        solver.checkCol();
        assertArrayEquals(board_expected, board);
        
        board = new String[][]{{"2", "-", "3", "1"}, {"1", "3", "-", "4"}, {"3", "1", "4", "-"}, {"-", "4", "1", "3"}};
        board_expected = new String[][]{{"2", "*", "3", "1"}, {"1", "3", "2", "4"}, {"3", "1", "4", "2"}, {"*", "4", "1", "3"}};

        solver = new SolverMethod1(board, validChars);

        solver.findEmptyCell();
        solver.checkRow();
        solver.checkCol();
        assertArrayEquals(board_expected, board);
    }

    @Test
    public void setPossibleValues() throws Exception {
        String[] validChars = {"1", "2", "3", "4"};
        String[][] board = {{"4","2","-","1"},{"-","-","-","2"},{"3","-","2","-"},{"-","4","-","3"}};
        int[] elmnt;
        Queue<int[]> emptyCoords = new LinkedList<int[]>();
        elmnt = new int[]{3, 0};
        emptyCoords.add(elmnt);

        elmnt = new int[]{3, 2};
        emptyCoords.add(elmnt);

        elmnt = new int[]{1, 1};
        emptyCoords.add(elmnt);

        elmnt = new int[]{1, 2};
        emptyCoords.add(elmnt);

        SolverMethod1 solver = new SolverMethod1(board, validChars);

        solver.findEmptyCell();
        solver.checkRow();
        solver.checkCol();
        solver.setPossibleValues();
        assertFalse(solver.isFinished);
        assertEquals(solver.emptyCoordinates.size(), 4);
//        assertEquals(Arrays.asList(solver.emptyCoordinates), Arrays.asList(emptyCoords));

        board = new String[][]{{"2", "-", "3", "1"}, {"1", "3", "-", "4"}, {"3", "1", "4", "-"}, {"-", "4", "1", "3"}};

        solver = new SolverMethod1(board, validChars);

        solver.findEmptyCell();
        solver.checkRow();
        solver.checkCol();
        solver.setPossibleValues();
        assertTrue(solver.isFinished);
        assertEquals(solver.emptyCoordinates.size(), 1);
    }
}