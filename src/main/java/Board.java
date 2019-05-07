import java.io.FileNotFoundException;
import java.util.*;

public class Board {
    private List<List<Integer>> board;

    public Board(String filePath) throws FileNotFoundException {
        BoardReader boardReader = BoardReaderFactory.getBoardReader(filePath);
        this.board = boardReader.readFile(filePath);
    }

    public Board(List<List<Integer>> board) {
        this.board = new ArrayList<>();
        for (List<Integer> row : board) {
            List<Integer> line = new ArrayList<>();
            for (Integer cell : row) {
                line.add(cell);
            }
            this.board.add(line);
        }
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

    public boolean isValid() {
        return this.boardSizeValid() && this.cellsValid() && this.rowsValid() && this.colsValid() && this.gridsValid();
    }

    public boolean isSolved() {
        return this.isFilled() && this.isValid();
    }

    public boolean boardSizeValid() {
        int boardSize = 9;
        if (board.size() != boardSize) {
            return false;
        } else {
            for (int i = 0; i < boardSize; i++) {
                if (board.get(i).size() != boardSize) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean cellsValid() {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                if (board.get(i).get(j) == null) {
                    continue;
                } else if (board.get(i).get(j) < 1 || board.get(i).get(j) > 9) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean rowsValid() {
        for (int i = 0; i < board.size(); i++) {
            Set<Integer> rowsBank = new HashSet<>();
            for (int j = 0; j < board.get(i).size(); j++) {
                if(board.get(i).get(j) == null) {
                    continue;
                } else {
                    if (!rowsBank.contains(board.get(i).get(j))) {
                        rowsBank.add(board.get(i).get(j));
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean colsValid() {
        for (int j = 0; j < board.get(0).size(); j++) {
            Set<Integer> colsBank = new HashSet<>();
            for (int i = 0; i < board.size(); i++) {
                if(board.get(i).get(j) == null) {
                    continue;
                } else {
                    if (!colsBank.contains(board.get(i).get(j))) {
                        colsBank.add(board.get(i).get(j));
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean gridsValid() {
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                if(!smallGridValid(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean smallGridValid(int rowStart, int colStart) {
        Set<Integer> gridBank = new HashSet<>();
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if(board.get(i).get(j) == null) {
                    continue;
                } else {
                    if (!gridBank.contains(board.get(i).get(j))) {
                        gridBank.add(board.get(i).get(j));
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isFilled() {
        for (List<Integer> row : board) {
            if (row.contains(null)) {
                return false;
            }
        }
        return true;
    }



    protected ArrayList<Board> getNeighbors() {
        ArrayList<Board> options = new ArrayList<>();
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                if (board.get(i).get(j) == null) {
                    for (int k = 1; k <= 9; k++) {
                        Board boardCopy = new Board(board);
                        boardCopy.fillACell(i, j, k);
                        if (boardCopy.isValid()) {
                            options.add(boardCopy);
                        }
                    }
                }
            }
        }
        return options;
    }


    public void fillACell(int row, int col, int val) {
        board.get(row).set(col, val);
    }
}
