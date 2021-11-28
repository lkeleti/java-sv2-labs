package inheritancemethods.plane;

public class Plane {
    public static void main(String[] args) {
        Passenger passenger = new Passenger("John Doe",100_000);
        PriorityPassenger priorityPassenger = new PriorityPassenger("Jane Doe",100_000,10);
        FirstClassPassenger firstClassPassenger = new FirstClassPassenger("Jack Doe",100_000,10);

        System.out.println(passenger.getName());
        System.out.println(passenger.getPriceOfPlaneTicket());

        System.out.println(priorityPassenger.getName());
        System.out.println(priorityPassenger.getPriceOfPlaneTicket());

        System.out.println(firstClassPassenger.getName());
        System.out.println(firstClassPassenger.getPriceOfPlaneTicket());
    }
}
