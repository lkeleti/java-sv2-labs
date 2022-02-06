package grad.okt2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Series {
    private List<Film> films = new ArrayList<>();

    public List<Film> getFilms() {
        return new ArrayList<>(films);
    }

    public void readFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                Optional<LocalDate> releaseDate = line.equals("NI") ? Optional.empty() : Optional.of(LocalDate.parse(line.replace(".", "-")));
                String title = br.readLine();
                line = br.readLine();
                int season = Integer.parseInt(line.split("x")[0]);
                int episode = Integer.parseInt(line.split("x")[1]);
                line = br.readLine();
                int length = Integer.parseInt(line);
                line = br.readLine();
                boolean seen = line.equals("1");
                films.add(new Film(releaseDate, title, season, episode, length, seen));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void exercise2() {
        System.out.println("2. feladat");
        long number = films.stream()
                .filter(f -> f.getReleaseDate().isPresent())
                .count();
        System.out.printf("A listában %d db vetítési dátummal rendelkező epizód van.%n", number);
    }

    public void exercise3() {
        System.out.println("3. feladat");
        double number = films.stream()
                .filter(Film::isSeen)
                .count() / (double) films.size() * 100;
        System.out.printf("A listában lévő epizódok %.2f-át látta.%n", number);
    }

    public void exercise4() {
        System.out.println("4. feladat");
        int sumTime = films.stream()
                .filter(Film::isSeen)
                .mapToInt(Film::getLength)
                .sum();
        int day = (sumTime / 60) / 24;
        sumTime = sumTime - (day * 60 * 24);
        int hour = sumTime / 60;
        int minute = sumTime - (hour * 60);
        System.out.printf("Sorozatnézéssel %d napot %d órát és %d percet töltött.%n", day, hour, minute);
    }

    public void exercise5() {
        System.out.println("5. feladat");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Adjon meg egy dátumot! Dátum= ");
        LocalDate date = LocalDate.parse(scanner.nextLine().replace(".", "-"));
        List<Film> notSeen = films.stream()
                .filter(f -> !f.isSeen())
                .filter(f -> f.getReleaseDate().isPresent())
                .filter(f -> f.getReleaseDate().get().isEqual(date) || f.getReleaseDate().get().isBefore(date))
                .toList();
        for (Film film : notSeen) {
            System.out.println(film.getSeason() + "x" + film.getEpisode() + "\t" + film.getTitle());
        }
    }

    public String Hetnapja(int ev, int ho, int nap) {
        String[] napok = {"v", "h", "k", "sze", "cs", "p", "szo"};
        int[] honapok = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        if (ho < 3) {
            ev -= 1;
        }
        return napok[(ev + (ev / 4) - (ev / 100) + (ev / 400) + honapok[ho - 1] + nap) % 7];
    }

    public void exercise7() {
        System.out.println("7. feladat");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Adja meg a hét egy napját (például cs)! Nap= ");
        String day = scanner.nextLine();

        List<String> filmTitleByDay = films.stream()
                .filter(f -> f.getReleaseDate().isPresent() &&
                        Hetnapja(f.getReleaseDate().get().getYear(),
                                f.getReleaseDate().get().getMonthValue(),
                                f.getReleaseDate().get().getDayOfMonth()
                        ).equals(day))
                .map(Film::getTitle)
                .distinct()
                .toList();
        for (String title : filmTitleByDay) {
            System.out.println(title);
        }
    }

    public void exercise8(Path path) {
        System.out.println("8. feladat");
        Map<String, Long> titleAndCount = films.stream()
                .collect(Collectors.groupingBy(Film::getTitle, Collectors.counting()));
        Map<String, Integer> titleAndLength = films.stream()
                .collect(Collectors.groupingBy(Film::getTitle, Collectors.summingInt(Film::getLength)));
        List<String> statistic = new ArrayList<>();

        List<String> keys = titleAndCount.keySet().stream().sorted().toList();
        for (String key : keys) {
            statistic.add(key + " " + titleAndLength.get(key) + " " + titleAndCount.get(key));
        }
        writeToFile(path, statistic);
    }

    private void writeToFile(Path path, List<String> statistic) {
        try {
            Files.write(path, statistic);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write to file!");
        }
    }
}
