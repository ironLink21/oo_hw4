package sudoku;

/**
 * Created by seth on 11/14/16.
 */
abstract class Solver {

    public abstract void findEmptyCell() {

    }

    public abstract void checkRow() {

    }

    public abstract void checkCol() {

    }

    public abstract void setPossibleValues(){

    }

    public void templatMethod() {
        findEmptyCell();
        checkRow();
        checkCol();
        setPossibleValues();
    }

}
