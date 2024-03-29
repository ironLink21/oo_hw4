package sudoku;

import java.util.*;

/**
 * Created by seth on 11/16/16.
 */
public class SolverMethod1 extends Solver {

    public SolverMethod1(String[][] board, String[] validChars) {
        this.board = board;
        this.validChars = Arrays.toString(validChars).replace("[","").replace("]","").replace(" ", "");
        this.emptyCoordinates = new LinkedList<int[]>();
    }

    public void operation1() {
        for(int i = 0; i < this.board.length; i++) {
            for(int j = 0 ; j < this.board.length; j++) {
                String[] cell = this.board[i][j].split("\\s+");
                if(cell[0].matches("-")) {
                    int[] coords = {i,j};
                    this.emptyCoordinates.add(coords);
                    this.board[i][j] = this.validChars;

                } else if (cell.length > 1) {
                    int[] coords = {i,j};
                    this.emptyCoordinates.add(coords);
                }
            }
        }
    }

    public void operation2() {
        for(int i = 0; i < this.emptyCoordinates.size(); i++) {
            int[] currCoord = this.emptyCoordinates.poll();
            int row = currCoord[0];
            int col = currCoord[1];

            List<String> emptyCellVal = new ArrayList<String>(Arrays.asList(this.board[row][col].split(",")));

            for(int j = 0; j < this.board.length; j++) {
                String[] cell = this.board[row][j].split("\\s+");
                if(cell.length == 1) {
                    if(j != col){
                        int index = emptyCellVal.indexOf(cell[0]);
                        if(index != -1) {
                            emptyCellVal.remove(index);
                            this.board[row][col] = emptyCellVal.toString().replace("[","").replace("]","").replace(" ", "");
                        }
                    }
                }
            }

            this.emptyCoordinates.add(currCoord);
        }
    }

    public void operation3() {
        for(int j = 0; j <= this.emptyCoordinates.size()+1; j++) {
            int[] currCoord = this.emptyCoordinates.poll();
            int row = currCoord[0];
            int col = currCoord[1];

            List<String> emptyCellVal = new ArrayList<String>(Arrays.asList(this.board[row][col].split(",")));

            for(int i = 0; i < this.board.length; i++) {
                String[] cell = this.board[i][col].split("\\s+");
                if(cell.length == 1) {
                    if(i != row){
                        int index = emptyCellVal.indexOf(cell[0]);
                        if(index != -1) {
                            emptyCellVal.remove(index);
                            this.board[row][col] = emptyCellVal.toString().replace(" ", "").replace("[","").replace("]","");
                        }
                    }
                }
            }

            String[] cell = this.board[row][col].split(",");
            if(cell.length != 1) {
                this.emptyCoordinates.add(currCoord);
            } else if(cell[0].matches("")){
                this.board[row][col] = "*";
                this.emptyCoordinates.add(currCoord);
            }
        }
    }

    public void operation4() {
        this.isFinished = true;

        for(int i = 0; i < this.emptyCoordinates.size(); i++) {
            int[] currCoord = this.emptyCoordinates.poll();
            int row = currCoord[0];
            int col = currCoord[1];

            String[] emptyCellVal = this.board[row][col].split(",");

            if(emptyCellVal[0] == "*"){
                System.out.print("unsolvable puzzle\n");
                this.isFinished = true;
            }

            if(emptyCellVal.length > 1){
                this.emptyCoordinates.add(currCoord);
                this.isFinished = false;
            }
        }
    }
}
