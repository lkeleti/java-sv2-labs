package compositionlist;

public class CapsulesMain {
    public static void main(String[] args) {
        Capsules capsules = new Capsules();
        capsules.addFirst("Barna");
        capsules.addFirst("Zöld");
        capsules.addLast("Fehér");
        capsules.addLast("Fekete");

        System.out.println(capsules.getColors());

        capsules.removeFirst();
        capsules.removeLast();

        System.out.println(capsules.getColors());
    }
}
