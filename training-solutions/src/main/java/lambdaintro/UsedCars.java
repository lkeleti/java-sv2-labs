package lambdaintro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UsedCars {
    private List<Car> cars;

    public UsedCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public List<Car> listCarsByPrice() {
        List<Car> result = new ArrayList<>(cars);
        result.sort(
                Comparator.comparingInt(Car::getPrice)
        );
        return result;
    }
    public List<Car> listCarsByLengthDesc() {
        List<Car> result = new ArrayList<>(cars);
        result.sort(
                Comparator.comparingDouble(Car::getLength).reversed()
        );
        return result;
    }
    public List<Car> listCarsOneBrandByType(String brand) {
        List<Car> result = new ArrayList<>();
        for (Car car: cars) {
            if (car.getBrand().equals(brand)) {
                result.add(car);
            }
        }
        result.sort(
                Comparator.comparing(Car::getType)
        );
        return result;
    }
}
