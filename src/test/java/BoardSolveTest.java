import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class BoardSolveTest {
    private static final List<Integer> nullList = new ArrayList<>(
            Arrays.asList(null, null, null, null, null, null, null, null, null)
    );

    @Test
    public void testPartialMissingBoard() {

        Board board = new Board(Arrays.asList(
                Arrays.asList(8, 2, 7, 1, 5, 4, 3, 9, 6),
                Arrays.asList(9, 6, 5, null, 2, 7, 1, 4, 8),
                Arrays.asList(3, 4, 1, 6, null, 9, 7, 5, 2),
                nullList,
                nullList,
                Arrays.asList(6, 1, 8, 9, 7, null, 4, 3, 5),
                Arrays.asList(7, 8, 6, 2, 3, 5, null, 1, 4),
                Arrays.asList(1, 5, 4, 7, 9, 6, 8, null, 3),
                Arrays.asList(2, 3, 9, 8, 4, null, null, null, null)
        ));

        SudokuSolver sdkSolver = new SudokuSolver(board);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(8, 2, 7, 1, 5, 4, 3, 9, 6),
                Arrays.asList(9, 6, 5, 3, 2, 7, 1, 4, 8),
                Arrays.asList(3, 4, 1, 6, 8, 9, 7, 5, 2),
                Arrays.asList(4, 7, 2, 5, 1, 3, 6, 8, 9),
                Arrays.asList(5, 9, 3, 4, 6, 8, 2, 7, 1),
                Arrays.asList(6, 1, 8, 9, 7, 2, 4, 3, 5),
                Arrays.asList(7, 8, 6, 2, 3, 5, 9, 1, 4),
                Arrays.asList(1, 5, 4, 7, 9, 6, 8, 2, 3),
                Arrays.asList(2, 3, 9, 8, 4, 1, 5, 6, 7)
        );

        assertEquals(expected, sdkSolver.solve().getBoard());

    }
}
