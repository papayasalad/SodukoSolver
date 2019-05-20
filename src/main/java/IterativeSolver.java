import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class IterativeSolver extends SudokuSolver{

    public IterativeSolver(String filepath) throws FileNotFoundException {
        super(filepath);
    }

    private static Set<Board> boardList = new HashSet<>();

    public Board solve() {
        Stack<Board> stack = new Stack<>();
        stack.push(super.getBoard());
        while(!stack.isEmpty()) {
            Board element = stack.pop();
            if (element.isSolved()) {
                return element;
            } else {
                for (Board option : element.getNeighbors()) {
                    if (!boardList.contains(option)) {
                        boardList.add(option);
                    }
                    stack.push(option);
                }
            }
        }
        return null;
    }

}
