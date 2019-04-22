import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SdkReader implements BoardReader {

    public List<List<Integer>> readFile(String filePath) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filePath));
        List<List<Integer>> board = new ArrayList<>();

        while (scan.hasNextLine()) {
            char[] data = scan.nextLine().toCharArray();
            List<Integer> line = new ArrayList<>();
            for (char element : data) {
                if (Character.isDigit(element)){
                    line.add(Character.getNumericValue(element));
                } else {
                    line.add(null);
                }
            }
            board.add(line);
        }
        return board;
    }
}
