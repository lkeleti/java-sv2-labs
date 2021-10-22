package introexceptionthrow;

public class AdultContent {
    public static void main(String[] args) {
        Adult adultOne = new Adult("Peter", 21);
        System.out.println(adultOne.getName() +  ", " + adultOne.getAge());
        Adult adultTwo = new Adult("Tom", 12);
        System.out.println(adultTwo.getName() +  ", " + adultTwo.getAge());
    }
}
