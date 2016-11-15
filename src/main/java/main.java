import sudoku.*;

/**
 * Created by seth on 11/14/16.
 */
public class main {
    int[][] board;

    public static void main(String[] args) throws Exception {
        Sudoku sudoku = new Sudoku();
        board = sudoku.SudokuParser("./resources/SamplePuzzles.Input/Puzzle-4x4-0001.txt");

    }
}
