package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private List<Ship> ships = new ArrayList<>();
    private int waitingPersons;
    private int waitingCargo;

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public int getWaitingPeople() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }

    public void loadShip(int passengers, int cargoWeight) {
        int tmpPassengers = passengers;
        int tmpCargoWeight = cargoWeight;
        for (Ship ship: ships) {
            if (ship.getClass() == Liner.class) {
                tmpPassengers = ((Liner)ship).loadPassenger(tmpPassengers);
            }
            if (ship.getClass() == CargoShip.class) {
                tmpCargoWeight = ((CargoShip)ship).loadCargo(tmpCargoWeight);
            }
            if (ship.getClass() == FerryBoat.class) {
                tmpPassengers = ((FerryBoat)ship).loadPassenger(tmpPassengers);
                tmpCargoWeight = ((FerryBoat)ship).loadCargo(tmpCargoWeight);
            }
        }
        waitingPersons = tmpPassengers;
        waitingCargo = tmpCargoWeight;
    }


}
