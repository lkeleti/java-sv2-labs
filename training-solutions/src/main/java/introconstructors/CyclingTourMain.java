package introconstructors;

import java.time.LocalDate;

public class CyclingTourMain {
    public static void main(String[] args) {
        CyclingTour cyclingTour = new CyclingTour("Velencei tó megkerülése", LocalDate.of(2022,6,1));
        System.out.println("A túra leírása: " + cyclingTour.getDescription());
        System.out.println("A túra időpontja: " + cyclingTour.getStartTime());
        System.out.println("Résztvevők száma: " + cyclingTour.getNumberOfPeople());
        System.out.println("Megtett kilométerek: " + cyclingTour.getKms());

        cyclingTour.registerPerson(5);
        cyclingTour.registerPerson(4);
        cyclingTour.registerPerson(1);

        cyclingTour.ride(10);
        cyclingTour.ride(10);
        cyclingTour.ride(8);

        System.out.println("A túra leírása: " + cyclingTour.getDescription());
        System.out.println("A túra időpontja: " + cyclingTour.getStartTime());
        System.out.println("Résztvevők száma: " + cyclingTour.getNumberOfPeople());
        System.out.println("Megtett kilométerek: " + cyclingTour.getKms());
    }
}
