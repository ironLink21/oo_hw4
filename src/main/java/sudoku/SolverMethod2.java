package sudoku;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by seth on 11/18/16.
 */
public class SolverMethod2 extends Solver{
    private Queue<int[]> emptyCoordinates;

    public SolverMethod2(String[][] board, String[] validChars) {
        this.board = board;
        this.validChars = Arrays.toString(validChars).replace("[","").replace("]","").replace(" ", "");
        emptyCoordinates = new LinkedList<int[]>();
    }

    public void findEmptyCell() {
        System.out.print("findEmptyCell2");
    }

    public void checkRow() {
        System.out.print("checkRow2");
    }

    public void checkCol() {
        System.out.print("checkCol2");
    }

    public void setPossibleValues() {
        System.out.print("setPossibleValues2");
    }

    public void checkBoard() {
        System.out.print("checkBoard2");
    }
}
