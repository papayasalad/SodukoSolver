import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class RecursiveSolver extends SudokuSolver {

    public RecursiveSolver(String filepath) throws FileNotFoundException {
        super(filepath);
    }

    private static Set<Board> boardList = new HashSet<>();

    public Board solve() {
        return solveHelper(super.getBoard(), boardList);
    }

    private static Board solveHelper(Board board, Set<Board> boardList) {
        if (board.isSolved()) {
            return board;
        }

        for (Board option : board.getNeighbors()) {
            if (!boardList.contains(option)) {
                boardList.add(option);
                Board result = solveHelper(option, boardList);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

}