import java.io.FileNotFoundException;
        import java.util.List;

public interface BoardReader {

    List<List<Integer>> readFile(String filePath) throws FileNotFoundException;

}
