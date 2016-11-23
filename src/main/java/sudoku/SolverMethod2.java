package sudoku;

import java.util.*;

/**
 * Created by seth on 11/18/16.
 */
public class SolverMethod2 extends Solver {
    private Queue<int[][]> emptyCoordinates;

    public SolverMethod2(String[][] board, String[] validChars) {
        this.board = board;
        this.validChars = Arrays.toString(validChars).replace("[","").replace("]","").replace(" ", "");

        String[] changeStr = this.validChars.split(",");
        this.validCharsInt = new int[this.validChars.length()];

        for(int i = 0; i < this.validChars.length(); i++) {
            try {
                this.validCharsInt[i] = Integer.parseInt(changeStr[i]);
            } catch (NumberFormatException nfe) {
//                TODO: log value if you want
            }
        }
        emptyCoordinates = new LinkedList<int[][]>();
    }

    public void operation1() {
        for(int i = 0; i < this.board.length; i++) {
            for(int j = 0 ; j < this.board.length; j++) {
                String[] cell = this.board[i][j].split("\\s+");
                if(cell[0].matches("-")) {
                    int[][] coords = {{i,j},this.validCharsInt};
                    this.emptyCoordinates.add(coords);

                } else if (cell.length > 1) {
                    int[][] coords = {{i,j},this.validCharsInt};
                    this.emptyCoordinates.add(coords);
                }
            }
        }
    }

    public void operation2() {
        for(int i = 0; i < this.emptyCoordinates.size(); i++) {
            int[][] currCoord = this.emptyCoordinates.poll();
            int[] coords = currCoord[0];
            int[] validChars = currCoord[1];

            List emptyCellVal = Arrays.asList(validChars);

            for(int j = 0; j < this.board.length; j++) {
                String[] cell = this.board[coords[0]][j].split("\\s+");
                if(cell.length == 1) {
                    if(j != coords[1]){
                        int index = emptyCellVal.indexOf(cell[0]);
                        if(index != -1) {
                            emptyCellVal.remove(index);
                        }
                    }
                }
            }

            this.emptyCoordinates.add(currCoord);
        }
    }

    public void operation3() {
        for(int j = 0; j <= this.emptyCoordinates.size()+1; j++) {
            int[][] currCoord = this.emptyCoordinates.poll();
            int[] coords = currCoord[0];
            int[] validChars = currCoord[1];

            List emptyCellVal = Arrays.asList(validChars);

            for(int i = 0; i < this.board.length; i++) {
                String[] cell = this.board[i][coords[1]].split("\\s+");
                if(cell.length == 1) {
                    if(i != coords[0]){
                        int index = emptyCellVal.indexOf(cell[0]);
                        if(index != -1) {
                            emptyCellVal.remove(index);
                        }
                    }
                }
            }

//            String[] cell = this.board[row][col].split(",");
//            if(cell.length != 1) {
//                this.emptyCoordinates.add(currCoord);
//            } else if(cell[0].matches("")){
//                this.board[row][col] = "*";
//                this.emptyCoordinates.add(currCoord);
//            }
        }
    }

    public void operation4() {

        List blockValues = Arrays.asList();

        int size = this.board.length;

        //loop through the cells
        for (int i = 0; i < size; i++) {
            for (int row = (int)(i * Math.sqrt(size)); row < Math.sqrt(size); row++) {
                for (int col = (int)(i * Math.sqrt(size)); col < Math.sqrt(size); col++) {
                    String value = this.board[row][col];
                    if (value != "-") {
                        blockValues.add(value);
                    }
                }
            }
            int[][] currCoord = this.emptyCoordinates.poll();
            int[] coords = currCoord[0];
            List validChars = Arrays.asList(currCoord[1]);

            for (int row = (int)(i * Math.sqrt(size)); row < Math.sqrt(size); row++) {
                for (int col = (int)(i * Math.sqrt(size)); col < Math.sqrt(size); col++) {
                    if (this.board[row][col] == "-") {
                        validChars.removeAll(blockValues);

                        int[][] coords_new = {{row,col},this.validCharsInt};
                        this.emptyCoordinates.add(coords_new);
                    }
                }
            }
        }

        for(int i = 0; i < this.emptyCoordinates.size(); i++) {
            int[][] currCoord = this.emptyCoordinates.poll();
            int[] coords = currCoord[0];
            List validChars = Arrays.asList(currCoord[1]);

            for(int row = 0; row < size; row++) {
                for(int col = 0; col < size; col++) {
                    if(validChars.size() == 1) {
                        if(coords[0] == row && coords[1] == col) {
                            this.board[row][col] = validChars.toString();
                        }
                    }
                }
            }

        }

    }

}
