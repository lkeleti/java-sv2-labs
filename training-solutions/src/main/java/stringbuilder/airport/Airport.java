package stringbuilder.airport;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public String getDeletedFlights() {
        StringBuilder result = new StringBuilder("Törölt járatok: " + System.lineSeparator());
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getStatus() == Status.DELETED) {
                result.append(flights.get(i).getFlightNumber());
                result.append(System.lineSeparator());
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Airport airport = new Airport();
        Flight flightOne = new Flight("B-2351", Status.DELETED);
        Flight flightTwo = new Flight("N-312561", Status.DELETED);
        Flight flightThree = new Flight("S-35", Status.DELETED);
        Flight flightFour = new Flight("H-41", Status.ACTIVE);
        Flight flightFive = new Flight("M-353535", Status.ACTIVE);
        Flight flightSix = new Flight("C-9229", Status.ACTIVE);

        airport.addFlight(flightOne);
        airport.addFlight(flightTwo);
        airport.addFlight(flightThree);
        airport.addFlight(flightFour);
        airport.addFlight(flightFive);
        airport.addFlight(flightSix);

        System.out.println(airport.getDeletedFlights());
    }
}
