package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance distance = new Distance(22.2,true);

        System.out.println(distance.getDistanceInKm());
        System.out.println(distance.isExact());

        int a = (int) distance.getDistanceInKm();
        System.out.println(a);
    }
}
