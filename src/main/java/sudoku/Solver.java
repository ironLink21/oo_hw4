package sudoku;

import java.util.Queue;

/**
 * Created by seth on 11/14/16.
 */
abstract class Solver {
    protected String[][] board, tempBoard;
    protected String validChars;
    protected boolean isFinished;
    protected static int sameBoardCounter;
    protected Queue<int[]> emptyCoordinates;

    public abstract void operation1();
    public abstract void operation2();
    public abstract void operation3();
    public abstract void operation4();

    public boolean templatMethod() {
        while(!isFinished) {
            operation1();
            operation2();
            operation3();
            operation4();
//            checkBoard();
//            printBoard();
            if(sameBoardCounter == 2){
                isFinished = true;
                return false;
            }
        }
        return true;
    }

    public void checkBoard() {
        int count = 0;
        if(tempBoard.length == 0) {
            tempBoard = this.board;
        }

        for(int i = 0; i < this.board.length; i++) {
            for(int j = 0; j < this.board.length; j++) {
                if(this.tempBoard[i][j] == this.board[i][j]){
                    count++;
                }
            }
        }

        int cellCnt = this.board.length * this.board.length;
        if(count == cellCnt) {
            this.sameBoardCounter++;
        }
    }

    public void printBoard() {
        for(int i = 0; i < this.board.length; i++) {
            String line = "";
            for (int j = 0; j < this.board.length; j++) {
                line += " " + board[i][j];
            }
            System.out.print(line + "\n");
        }
    }
}
