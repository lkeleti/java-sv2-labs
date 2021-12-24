package exceptionmulticatch.aid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Aid {
    private  int amount;

    public Aid(int amount) {
        this.amount = amount;
    }

    public List<String> countAmountsOfAid(Path path) {
        List<String> result = new ArrayList<>();
        List<String> lines = readFromFile(path);
        for (String line: lines) {
            String[] datas = line.split(" ");
            try {
                int number = amount/ Integer.parseInt(datas[1]);
                result.add(datas[0] + " " + number);
            }
            catch (NumberFormatException | ArithmeticException | NullPointerException | ArrayIndexOutOfBoundsException e) {
                throw new IllegalStateException("Something went wrong while counting.",e);
            }
        }
        return result;
    }

    private List<String> readFromFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException |NullPointerException ioe) {
            throw new IllegalStateException("Something went wrong while counting.", ioe);
        }
    }
}
