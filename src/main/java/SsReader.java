import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SsReader implements BoardReader{

    public List<List<Integer>> readFile(String filePath) throws FileNotFoundException {

        Scanner scan = new Scanner(new File(filePath));
        List<List<Integer>> board = new ArrayList<>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (!line.contains("-")) {
                char[] data = line.toCharArray();
                List<Integer> row = new ArrayList<>();
                for (char element : data) {
                    if (Character.isDigit(element)) {
                        row.add(Character.getNumericValue(element));
                    } else if (element == '.') {
                        row.add(null);
                    }
                }
                board.add(row);
            }
        }
        return board;
    }
}
