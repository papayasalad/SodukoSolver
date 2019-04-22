import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SsReaderTest {
    @Test
    public void testReadFormat() throws IOException {
        Board board = new Board("src/main/resources/puzzle.ss");
        List<List<Integer>> expectedBoard = Arrays.asList(
                Arrays.asList(1, null, null, null, null, null, 7, null, null),
                Arrays.asList(null, 2, null, null, null, null, 5, null, null),
                Arrays.asList(6, null, null, 3, 8, null, null, null, null),
                Arrays.asList(null, 7, 8, null, null, null, null, null, null),
                Arrays.asList(null, null, null, 6, null, 9, null, null, null),
                Arrays.asList(null, null, null, null, null, null, 1, 4, null),
                Arrays.asList(null, null, null, null, 2, 5, null, null, 9),
                Arrays.asList(null, null, 3, null, null, null, null, 6, null),
                Arrays.asList(null, null, 4, null, null, null, null, null, 2)
        );

        assertEquals(expectedBoard, board.getBoard());
    }

    @Test
    public void testEmptyPuzzle() throws IOException {
        Board board = new Board("src/main/resources/empty_puzzle.ss");
        assertEquals(Collections.emptyList(), board.getBoard());
    }

    @Test
    public void testBoardPrint() throws IOException {
        String filePath = "src/main/resources/puzzle.ss";

        Board board = new Board(filePath);
        String text = new String(Files.readAllBytes(Paths.get(filePath)));
        assertEquals(text, board.toString());
    }
}
