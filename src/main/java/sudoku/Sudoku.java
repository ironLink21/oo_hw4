package sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by seth on 11/14/16.
 */
public class Sudoku {

    private int size;
    private Boolean isInvalid = false;
    public String[][] board;


    public Sudoku() {
    }

    public void SudokuParser(String fin) {
        int count = 0, i = 0, j = 0;

        try {
            BufferedReader lineReader = new BufferedReader(new FileReader(fin));
            String lineText = null;

            while ((lineText = lineReader.readLine()) != null) {
                if(count == 0) {
//                  getting the size of the sudoku board
                    this.size = Integer.parseInt(lineText);
                    this.board = new String[this.size][this.size];

                } else if(count > 1) {
                    String[] finArray = lineText.split("\\s+");
//                  filling the board with the correct values
                    if(i < finArray.length) {
                        for(j = 0; j < finArray.length; j++) {
//                        check to make sure only numbers and '-' chacters
                            if(finArray[j].matches("^[0-9]+$") || finArray[j].matches("-")) {
                                this.board[i][j] = finArray[j];
                            } else {
                                this.isInvalid = true;
                            }
                        }
                        i++;
                    }
                } else if(count > this.size) {
                    this.isInvalid = true;
                }

                count++;
            }

            lineReader.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void printBoard() {
        if(!this.isInvalid) {
            for(int i = 0; i < this.size; i++) {
                String line = "";
                for (int j = 0; j < this.size; j++) {
                    line += " " + board[i][j];
                }
                System.out.print(line + "\n");
            }

        } else {
            System.out.print("Invalid board detected");
        }
    }
}
