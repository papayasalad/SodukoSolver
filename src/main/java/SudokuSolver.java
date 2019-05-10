import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
    private Board board;

    SudokuSolver(String filePath) throws FileNotFoundException {
        this.board = new Board(filePath);
    }

    SudokuSolver(Board board) {
        this.board = board;
    }

    private static Set<Board> boardList = new HashSet<Board>();

    private static boolean duplicates(Set<Board> boardList, Board board) {
        for (Board recordedBoard: boardList) {
            if (board.equal(recordedBoard)) {
                return true;
            }
        }
        return false;
    }

    public Board solve() {
        return solveHelper(this.board, boardList);
    }

    private static Board solveHelper(Board board, Set<Board> boardList) {
        if (board.isSolved()) {
            return board;
        }

        for (Board option : board.getNeighbors()) {
            if (!duplicates(boardList, option)) {
                boardList.add(option);
                Board result = solveHelper(option, boardList);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws FileNotFoundException {

        SudokuSolver sdkSolver = new SudokuSolver("src/main/resources/puzzle.sdk");
        System.out.println(sdkSolver.board);

        System.out.println(" \n------ Below is the solution of above Sudoku Boards ------\n ");

        Board solution = sdkSolver.solve();
        System.out.println(solution);

    }
}
