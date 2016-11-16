package sudoku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by seth on 11/14/16.
 */
public class Sudoku {

    private int size;
    private Boolean isInvalid = false;
    public String[] validChars;
    public String[][] board;


    public Sudoku() {
    }

    public void SudokuParser(String fin) {
        int count = 0, i = 0, j = 0;

        try {
            String finPath = new File(fin).getAbsolutePath();
            BufferedReader lineReader = new BufferedReader(new FileReader(finPath));
            String lineText = null;

            while ((lineText = lineReader.readLine()) != null) {
                if(count == 0) {
                    this.size = Integer.parseInt(lineText);
                    this.board = new String[this.size][this.size];

                } else if (count == 1) {
                    this.validChars = lineText.split("\\s+");

                } else {
                    String[] finArray = lineText.split("\\s+");
                    if(i < finArray.length) {
                        for(j = 0; j < finArray.length; j++) {
                            if(Arrays.asList(this.validChars).contains(finArray[j]) || finArray[j].matches("-")) {
                                this.board[i][j] = finArray[j];
                            } else {
                                System.out.print("Invalid board detected");
                            }
                        }
                        i++;
                    }
                }

                count++;
            }

            lineReader.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void printBoard() {
        for(int i = 0; i < this.size; i++) {
            String line = "";
            for (int j = 0; j < this.size; j++) {
                line += " " + board[i][j];
            }
            System.out.print(line + "\n");
        }

    }
}
