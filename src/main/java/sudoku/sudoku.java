package sudoku;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by seth on 11/14/16.
 */
public class sudoku {
    public int[][] board;

    public sudoku(String fin) {

    }

    public void sudokuParser(String fin) {
        try {
            for (String line : Files.readAllLines(Paths.get(fin))) {
                // ...
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
