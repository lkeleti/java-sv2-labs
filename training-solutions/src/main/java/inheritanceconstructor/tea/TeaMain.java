package inheritanceconstructor.tea;

public class TeaMain {
    public static void main(String[] args) {
        Tea tea = new Tea("Általános tea",100);
        System.out.println(tea.getName());
        System.out.println(tea.getPrice());

        HerbalTea herbalTea = new HerbalTea("Herbál tea", 150);
        System.out.println(herbalTea.getName());
        System.out.println(herbalTea.getPrice());
    }
}
