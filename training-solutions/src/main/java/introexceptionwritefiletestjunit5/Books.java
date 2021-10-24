package introexceptionwritefiletestjunit5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<String> bookNewList = new ArrayList<>();

    public void refactoringFile(Path pathToRead, Path pathToWrite) throws IOException {
        List<String> lines = Files.readAllLines(pathToRead);
        for (String line: lines) {
            String[] datas = line.split(";");
            bookNewList.add(datas[2] + ": " + datas[1]);
        }
        Files.write(pathToWrite, bookNewList);
    }
}
