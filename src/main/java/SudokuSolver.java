import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

// This class includes a method solve() that returns a board solution. I tend to favor this coding style because
// it not only allows us to print out the original board but also details in the middle if we want to. It is easier
// to debug compared to the other class Solver2 which creates a member variable of solution.

public class SudokuSolver {
    private Board board;

    public SudokuSolver(String filePath) throws FileNotFoundException {
        this.board = new Board(filePath);
    }

    public SudokuSolver(Board board) {
        this.board = board;
    }

    private static Set<Board> boardList = new HashSet<>();

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
