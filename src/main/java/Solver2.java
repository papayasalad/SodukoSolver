import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

// This class creates a member variable Board solution. In the constructor where solution gets initialized, sokoku
// puzzle is solved. It looks like a black box that directly gives the result of puzzle simply by accessing the field
// . However I feel like it is better to avoid using this coding style because it is kinda difficult to tell what
// goes wrong in the middle.

public class Solver2 {
    private Board solution;

    public Solver2(String filePath) throws FileNotFoundException {
        Board board = new Board(filePath);

        Set<Board> boardList = new HashSet<>();

        solution = solveHelper(board, boardList);
    }

    public Board getSolution() {
        return this.solution;
    }

    private static boolean duplicates(Set<Board> boardList, Board board) {
        for (Board recordedBoard: boardList) {
            if (board.equal(recordedBoard)) {
                return true;
            }
        }
        return false;
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
        Solver2 sdkSolver = new Solver2("src/main/resources/puzzle.sdk");
        System.out.println(sdkSolver.solution);
    }
}
