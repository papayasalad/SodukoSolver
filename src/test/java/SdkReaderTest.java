import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SdkReaderTest {
    @Test
    public void testReadFormat() throws IOException {
        Board board = new Board("src/main/resources/puzzle.sdk");
        List<List<Integer>> expectedBoard = Arrays.asList(
                Arrays.asList(5, null, null, null, null, 7, null, null, 1),
                Arrays.asList(9, 6, null, null, 8, 4, 5, null, null),
                Arrays.asList(null, 7, 8, null, 5, null, null, 9, null),
                Arrays.asList(4, null, null, 5, null, null, 8, null, null),
                Arrays.asList(null, 5, 6, 8, null, 2, 7, 4, null),
                Arrays.asList(null, null, 2, null, null, 9, null, null, 6),
                Arrays.asList(null, 2, null, null, 6, null, 9, 3, null),
                Arrays.asList(null, null, 7, 9, 4, null, null, 1, 5),
                Arrays.asList(8, null, null, 1, null, null, null, null, 7)
        );

        assertEquals(expectedBoard, board.getBoard());
    }

    @Test
    public void testEmptyPuzzle() throws IOException {
        Board board = new Board("src/main/resources/empty_puzzle.sdk");
        assertEquals(Collections.emptyList(), board.getBoard());
    }

    @Test
    public void testBoardPrint() throws IOException {
        String filePath = "src/main/resources/puzzle.sdk";

        Board board = new Board(filePath);
        String text = new String(Files.readAllBytes(Paths.get(filePath)));
        assertEquals(text, board.toString());
    }
}
