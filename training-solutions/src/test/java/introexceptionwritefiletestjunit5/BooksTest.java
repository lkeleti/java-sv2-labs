package introexceptionwritefiletestjunit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

class BooksTest {
    @TempDir
    File temporaryFolder;

    @Test
    void bookRefactoringTest() throws IOException {
        Path pathToWrite = temporaryFolder.toPath().resolve("booklists.txt");
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
