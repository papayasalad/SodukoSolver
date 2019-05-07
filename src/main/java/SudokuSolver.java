import java.io.FileNotFoundException;

public class SudokuSolver {
    private Board board;

    private SudokuSolver(String filePath) throws FileNotFoundException {
        this.board = new Board(filePath);
    }

    private Board solve() {
        return solveHelper(this.board);
    }

    private static Board solveHelper(Board board) {
        if (board.isSolved()) {
            return board;
        }

        for (Board option : board.getNeighbors()) {
            if (solveHelper(option) != null) {
                return solveHelper(option);
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
