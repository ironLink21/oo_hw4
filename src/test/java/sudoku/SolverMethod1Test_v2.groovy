package sudoku

/**
 * Created by seth on 11/18/16.
 */
class SolverMethod1Test_v2 extends GroovyTestCase {
    void testFindEmptyCell() {
        String validChars = "1 2 3 4";
        String[][] board = [["4","2","-","1"],["-","-","-","2"],["3","-","2","-"],["-","4","-","3"]];

        Solver method1 = new SolverMethod1(board, validChars).findEmptyCell();
        assert method1.emptyCoordinates == [[0,2],[1,0],[1,1],[1,2],[2,1],[2,3],[3,0],[3,2]];
    }
}
