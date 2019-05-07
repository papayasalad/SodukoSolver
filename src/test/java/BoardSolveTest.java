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
                Arrays.asList(5, null, 4, 6, 7, null, 9, 1, 2),
                Arrays.asList(6, 7, 2, null, 9, 5, null, 4, 8),
                Arrays.asList(1, 9, 8, 3, 4, 2, 5, 6, 7),
                Arrays.asList(8, 5, 9, 7, 6, 1, 4, 2, 3),
                Arrays.asList(4, 2, 6, 8, 5, 3, 7, 9, 1),
                Arrays.asList(7, 1, 3, 9, 2, 4, 8, 5, 6),
                Arrays.asList(9, 6, 1, 5, 3, 7, 2, 8, 4),
                Arrays.asList(2, 8, 7, 4, 1, 9, 6, 3, 5),
                Arrays.asList(3, 4, 5, 2, 8, 6, 1, 7, 9)
        ));

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(5, 3, 4, 6, 7, 8, 9, 1, 2),
                Arrays.asList(6, 7, 2, 1, 9, 5, 3, 4, 8),
                Arrays.asList(1, 9, 8, 3, 4, 2, 5, 6, 7),
                Arrays.asList(8, 5, 9, 7, 6, 1, 4, 2, 3),
                Arrays.asList(4, 2, 6, 8, 5, 3, 7, 9, 1),
                Arrays.asList(7, 1, 3, 9, 2, 4, 8, 5, 6),
                Arrays.asList(9, 6, 1, 5, 3, 7, 2, 8, 4),
                Arrays.asList(2, 8, 7, 4, 1, 9, 6, 3, 5),
                Arrays.asList(3, 4, 5, 2, 8, 6, 1, 7, 9)
        );

        //assertEquals(expected, solveHelper(board));

    }
}
