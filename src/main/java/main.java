import sudoku.*;

/**
 * Created by seth on 11/14/16.
 */
public class main {

    public static void main(String[] args) throws Exception {
        Sudoku sudoku = new Sudoku();
//        sudoku.SudokuParser("src/main/resources/SamplePuzzles/Input/solvable.txt"); // solved
//        sudoku.SudokuParser("src/main/resources/SamplePuzzles/Input/Puzzle-4x4-0001.txt"); // solved
//        sudoku.SudokuParser("src/main/resources/SamplePuzzles/Input/Puzzle-4x4-0002.txt"); // solved
        sudoku.SudokuParser("src/main/resources/SamplePuzzles/Input/Puzzle-9x9-0001.txt");
//        sudoku.SudokuParser("src/main/resources/SamplePuzzles/Input/Puzzle-9x9-0002.txt");
//        sudoku.SudokuParser("src/main/resources/SamplePuzzles/Input/Puzzle-16x16-0001.txt");
//        sudoku.SudokuParser("src/main/resources/SamplePuzzles/Input/Puzzle-25x25-0901.txt");
        sudoku.runSolver();
        sudoku.printBoard();
    }
}
