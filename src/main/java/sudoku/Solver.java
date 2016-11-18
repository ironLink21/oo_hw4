package sudoku;

/**
 * Created by seth on 11/14/16.
 */
abstract class Solver {
    protected String[][] board;
    protected String validChars;
    protected boolean isFinished;

    public abstract void findEmptyCell();
    public abstract void checkRow();
    public abstract void checkCol();
    public abstract void setPossibleValues();
    public abstract void printBoard();

    public void templatMethod() {
        while(!isFinished) {
            findEmptyCell();
            checkRow();
            checkCol();
            setPossibleValues();
            printBoard();
        }
    }

}
