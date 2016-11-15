package sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by seth on 11/14/16.
 */
public class Sudoku {

    private int size;
    public int[][] board;

    public Sudoku() {
    }

    public int[][] SudokuParser(String fin) {
        int count = 0, i = 0, j = 0;

        try {
            BufferedReader lineReader = new BufferedReader(new FileReader(fin));
            String lineText = null;

            while ((lineText = lineReader.readLine()) != null) {
                if(count == 0) {
                    this.size = Integer.parseInt(lineText);
                    board = new int[this.size][this.size];
                    count++;
                } else {
                    String[] finArray = lineText.split("\\s+");
                    for(j = 0; j < finArray.length; j++) {
                        board[i][j] = Integer.parseInt(finArray[j]);
                    }
                    i++;
                }
            }

            lineReader.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }

        return board;
    }
}
