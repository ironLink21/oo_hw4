package sudoku;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by seth on 11/18/16.
 */
public class SolverMethod2 extends Solver{
    private Queue<int[]> emptyCoordinates;

    public SolverMethod2(String[][] board, String[] validChars) {
        this.board = board;
        this.validChars = Arrays.toString(validChars).replace("[","").replace("]","").replace(" ", "");
        emptyCoordinates = new LinkedList<int[]>();
    }

    public void operation1() {
        System.out.print("findEmptyCell2");
    }

    public void operation2() {
        System.out.print("checkRow2");
    }

    public void operation3() {
        System.out.print("checkCol2");
    }

    public void operation4() {

//        List<char> blockValues = new List<char>();
//
//        //loop through the different blocks
//        for (int i = 0; i < puzzleSize; i++)
//        {
//            for (int row = (int)(i * Math.Sqrt(puzzleSize)); row < Math.Sqrt(puzzleSize); row++)
//            {
//                for (int col = (int)(i * Math.Sqrt(puzzleSize)); col < Math.Sqrt(puzzleSize); col++)
//                {
//                    //int rowBlock = emptyCells[cell][0];
//                    //int colBlock = emptyCells[cell][1];
//                    char value = puzzleBoard[row, col].actualValue;
//                    if (value != '-')
//                    {
//                        blockValues.Add(value);
//                    }
//                }
//            }
//
//            for (int row = (int)(i * Math.Sqrt(puzzleSize)); row < Math.Sqrt(puzzleSize); row++)
//            {
//                for (int col = (int)(i * Math.Sqrt(puzzleSize)); col < Math.Sqrt(puzzleSize); col++)
//                {
//                    if (puzzleBoard[row, col].actualValue == '-')
//                    {
//                        puzzleBoard[row, col].possibleValues.RemoveAll(ab => blockValues.Contains(ab));
//                    }
//
//                }
//            }
//        }
    }

}
