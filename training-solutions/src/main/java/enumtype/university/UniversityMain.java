package enumtype.university;

public class UniversityMain {
    public static void main(String[] args) {
        for (University item: University.values()) {
            System.out.println(item.name() + (item.name().length() < 4 ? "\t\t" : "\t") + item.getName());
        }
        System.out.println(University.valueOf("BGE").getName());
        System.out.println(University.GDF.name());
    }
}
