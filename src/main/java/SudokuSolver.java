import java.io.FileNotFoundException;

public class SudokuSolver {
    private Board board;

    private SudokuSolver(String filePath) throws FileNotFoundException {
        this.board = new Board(filePath);
    }

    public static void main(String[] args) throws FileNotFoundException {

        SudokuSolver sdkSolver = new SudokuSolver("src/main/resources/puzzle.sdk");
        System.out.println(sdkSolver.board);

        System.out.println(" \n------ Here is a line separating two Sudoku Boards ------\n ");

        SudokuSolver ssSolver = new SudokuSolver("src/main/resources/puzzle.ss");
        System.out.println(ssSolver.board);

    }
}
