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
    public String[] validChars;
    public String[][] board;


    public Sudoku() {
    }

    public void SudokuParser(String fin) {
        int count = 0, i = 0;

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

                } else if (count >= 2 && i <= this.size-1) {
                    String[] finArray = lineText.split("\\s+");
                    for(int j = 0; j < finArray.length; j++) {
                        if(Arrays.asList(this.validChars).contains(finArray[j]) || finArray[j].matches("-")) {
                            this.board[i][j] = finArray[j];
                        } else {
                            System.out.print("Invalid board detected, size:" + this.size + " character:" + finArray[j]);
                            System.exit(1);
                        }
                    }
                    i++;
                }
                count++;
            }

            lineReader.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void runSolver() {
        Solver method1 = new SolverMethod1(this.board, this.validChars);
        boolean isSolved = method1.templatMethod();

        if(!isSolved) {
            Solver method2 = new SolverMethod2(this.board, this.validChars);
            isSolved = method2.templatMethod();
        }

//        System.out.print("testing");
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
