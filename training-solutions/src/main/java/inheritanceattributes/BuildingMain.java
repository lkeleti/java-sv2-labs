package inheritanceattributes;

public class BuildingMain {
    public static void main(String[] args) {
        Building building = new Building("Sarokház",1000,2);
        SchoolBuilding schoolBuilding = new SchoolBuilding("Kodály",1500,3,102);

        System.out.println(building.name);
        System.out.println(building.area);
        System.out.println(building.getFloors());

        System.out.println(schoolBuilding.name);
        System.out.println(schoolBuilding.area);
        System.out.println(schoolBuilding.getFloors());
        System.out.println(schoolBuilding.getNumberOfClassRooms());
    }
}
