import java.io.FileNotFoundException;
import java.util.List;

public class Board {
    private List<List<Integer>> board;

    public Board(String filePath) throws FileNotFoundException {
        BoardReader boardReader = BoardReaderFactory.getBoardReader(filePath);
        board = boardReader.readFile(filePath);
    }

    public List<List<Integer>> getBoard() { return board; }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (List<Integer> row: board) {
            for (Integer item : row) {
                if (item != null) {
                    res.append(item.toString());
                } else {
                    res.append(".");
                }
            }
            res.append("\n");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
