import sudoku.*;

/**
 * Created by seth on 11/14/16.
 */
public class main {
    static int[][] board;

    public static void main(String[] args) throws Exception {
        Sudoku sudoku = new Sudoku();
        sudoku.SudokuParser("src/main/resources/SamplePuzzles/Input/Puzzle-4x4-0001.txt");

        sudoku.printBoard();
    }
}
