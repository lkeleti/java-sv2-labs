package compositionlist;

public class CapsulesMain {
    public static void main(String[] args) {
        Capsules capsules = new Capsules();
        capsules.addFirst("barna");
        capsules.addFirst("Zöld");
        capsules.addLast("Fehér");
        capsules.addLast("Fekete");

        System.out.println(capsules.getColors());
    }
}
