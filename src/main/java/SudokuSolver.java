import java.io.FileNotFoundException;

public abstract class SudokuSolver {
    private Board board;

    public SudokuSolver(String filepath) throws FileNotFoundException {
        this.board = new Board(filepath);
    }

    public abstract Board solve();

    public Board getBoard() { return this.board; }

}
