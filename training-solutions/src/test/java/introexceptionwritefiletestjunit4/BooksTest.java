package introexceptionwritefiletestjunit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BooksTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void bookRefactoringTest() throws IOException {
        Path pathToWrite = temporaryFolder.newFile("booklists.txt").toPath();
        Path pathToRead = Paths.get("src/test/resources/books.txt");

        List<String> expectedList = Arrays.asList(
                "Gárdonyi Géza: Egri csillagok",
                "Molnár Ferenc: Pál utcai fiúk",
                "Fekete István: Tüskevár",
                "Jókai Mór: Kőszívű ember fiai"
        );
        Books books = new Books();
        books.refactoringFile(pathToRead, pathToWrite);

        assertEquals(expectedList, Files.readAllLines(pathToWrite));
    }
}
