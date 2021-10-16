package enumtype.position;

public class PositionMain {
    public static void main(String[] args) {
        for (Position item: Position.values()) {
            System.out.println("Beosztás neve: " + item.name() + " Fizetés: " + item.getSalary() +
                    " Béren kívüli juttatások: " + item.getBenefit());
        }
    }
}
