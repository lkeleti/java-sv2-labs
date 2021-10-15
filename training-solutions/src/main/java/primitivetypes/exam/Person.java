package primitivetypes.exam;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate birthDate;
    private int zip;
    private double avgRating;

    public Person(String name, LocalDate birthDate, int zip, double avgRating) {
        this.name = name;
        this.birthDate = birthDate;
        this.zip = zip;
        this.avgRating = avgRating;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getZip() {
        return zip;
    }

    public double getAvgRating() {
        return avgRating;
    }

    @Override
    public String toString() {
        return "{" +
                "name=" + name +
                ", birthDate=" + birthDate +
                ", zip=" + zip +
                ", avgRating=" + avgRating +
                '}';
    }
}
