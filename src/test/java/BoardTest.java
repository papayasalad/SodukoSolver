import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    @Test
    public void testOneRowFail() throws IOException {
        Board board = new Board("src/test/resources/oneRowFail.sdk");
        assertEquals(false, board.isValid());
    }

    @Test
    public void testOneColFail() throws IOException {
        Board board = new Board("src/test/resources/oneColFail.sdk");
        assertEquals(false, board.isValid());
    }

    @Test
    public void testOneGridFail() throws IOException {
        Board board = new Board("src/test/resources/oneGridFail.sdk");
        assertEquals(false, board.isValid());
    }

    @Test
    public void testContainZero() throws IOException {
        Board board = new Board("src/test/resources/invalidData0.sdk");
        assertEquals(false, board.isValid());
    }

    @Test
    public void testContainLetter() throws IOException {
        Board board = new Board("src/test/resources/invalidDataLetter.sdk");
        assertEquals(false, board.isValid());
    }

    @Test
    public void testEmptyInput() throws IOException {
        Board board = new Board("src/main/resources/empty_puzzle.sdk");
        assertEquals(false, board.isValid());
    }

    @Test
    public void testValidIncomplete() throws IOException {
        Board board = new Board("src/main/resources/puzzle.sdk");
        assertEquals(true, board.isValid());
    }

    @Test
    public void testComplete() throws IOException {
        Board board = new Board("src/test/resources/correctComplete.sdk");
        assertEquals(true, board.isValid());
    }

    @Test
    public void testEmptySolved() throws IOException {
        Board board = new Board("src/main/resources/empty_puzzle.sdk");
        assertEquals(false, board.isSolved());
    }

    @Test
    public void testCompleteNotSolved() throws IOException {
        Board board = new Board("src/test/resources/incorrectComplete.sdk");
        assertEquals(false, board.isSolved());
    }

    @Test
    public void testValidNotSolved() throws IOException {
        Board board = new Board("src/main/resources/puzzle.sdk");
        assertEquals(false, board.isSolved());
    }

    @Test
    public void testCorrectSolved() throws IOException {
        Board board = new Board("src/test/resources/correctComplete.sdk");
        assertEquals(true, board.isSolved());
    }

}
