package introexceptioncheckedtrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Neptun {
    private List<String > neptunCodes = new ArrayList<>();

    private void readFile(String fileName) throws IOException {
        List<String> datas = Files.readAllLines(Paths.get(fileName));
        for (String data: datas) {
            String neptunCode = data.split(",")[1];
            neptunCodes.add(neptunCode);
        }
    }

    public void  prepareDatas(String fileName) throws IOException{
        readFile(fileName);
    }

    public List<String> getNeptunCodes() {
        return neptunCodes;
    }
}
