package conventions;

public class CarMain {
    public static void main(String[] args) {
        Car car = new Car("BMW", "Diesel", 4, 5);
        car.addModelName("X6");

        System.out.println(car.getCarType());
        System.out.println(car.getDoors());
        System.out.println(car.getEngineType());
        System.out.println(car.getPersons());

        car.setCarType("Fiat");
        car.setDoors(2);
        car.setEngineType("Gasoline");
        car.setPersons(4);

        System.out.println(car.getCarType());
        System.out.println(car.getDoors());
        System.out.println(car.getEngineType());
        System.out.println(car.getPersons());
    }
}
