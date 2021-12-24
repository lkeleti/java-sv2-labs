package exceptionresource.hiddenword;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class HiddenWord {
    public String getHiddenWord(Path path) {
        String result = "";
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result += findChar(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return result;
    }

    private String findChar(String line) {
        for (Character c : line.toCharArray()) {
            if (!Character.isDigit(c)) {
                return c.toString();
            }
        }
        return " ";
    }
}
