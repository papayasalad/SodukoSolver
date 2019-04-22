public class BoardReaderFactory {
    public static BoardReader getBoardReader(String filePath) {
        if (filePath.endsWith("sdk")) {
            return new SdkReader();
        } else if (filePath.endsWith("ss")){
            return new SsReader();
        }
        throw new UnsupportedOperationException("Filepath " + filePath + " is not valid");
    }
}
