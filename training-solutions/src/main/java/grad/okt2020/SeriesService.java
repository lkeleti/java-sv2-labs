package grad.okt2020;

import java.nio.file.Path;

public class SeriesService {
    public static void main(String[] args) {
        Series series = new Series();
        series.readFromFile(Path.of("src/main/resources/grad/lista.txt"));
        series.exercise2();
        series.exercise3();
        series.exercise4();
        series.exercise5();
        series.exercise7();
        series.exercise8(Path.of("src/main/resources/grad/summa.txt"));
    }
}
