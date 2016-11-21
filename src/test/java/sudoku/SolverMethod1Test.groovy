package sudoku

import static java.lang.Boolean.FALSE
import static java.lang.Boolean.TRUE

/**
 * Created by seth on 11/18/16.
 */
class SolverMethod1Test extends GroovyTestCase {
    void testFindEmptyCell() {
        String validChars = "1 2 3 4";
        String[][] board = [["4","2","-","1"],["-","-","-","2"],["3","-","2","-"],["-","4","-","3"]];

        Solver method1 = new SolverMethod1(board, validChars).findEmptyCell();
        assert method1.emptyCoordinates == [[0,2],[1,0],[1,1],[1,2],[2,1],[2,3],[3,0],[3,2]];

//        assert board == [["4","2","3","1"],["1","3","4","2"],["3","1","2","4"],["2","4","1","3"]];
    }

//    void testCheckRow() {
//
//    }
//
//    void testCheckCol() {
//
//    }
//
//    void testSetPossibleValues() {
//
//    }
}
