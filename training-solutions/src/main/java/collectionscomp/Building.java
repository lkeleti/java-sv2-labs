package collectionscomp;

import java.util.Objects;
import java.util.TreeSet;

public class Building implements Comparable<Building> {
    private String address;
    private double area;
    private int floors;

    public Building(String address, double area, int floors) {
        this.address = address;
        this.area = area;
        this.floors = floors;
    }

    public String getAddress() {
        return address;
    }

    public double getArea() {
        return area;
    }

    public int getFloors() {
        return floors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return floors == building.floors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(floors);
    }

    @Override
    public int compareTo(Building o) {
        return this.floors - o.getFloors();
    }

    @Override
    public String toString() {
        return "Building{" +
                "address='" + address + '\'' +
                ", area=" + area +
                ", floors=" + floors +
                '}';
    }

    public static void main(String[] args) {
        TreeSet<Building> buildings = new TreeSet<>();
        buildings.add(new Building("Budapest", 5000.0,50));
        buildings.add(new Building("Szolnok", 2400.0,24));
        buildings.add(new Building("Abony", 100.0,1));

        System.out.println(buildings);
    }
}
