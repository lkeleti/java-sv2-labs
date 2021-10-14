package compositionlist.computer;

public class PersonalComputerMain {
    public static void main(String[] args) {
        PersonalComputer personalComputer = new PersonalComputer(new Cpu("Intel Core-i5 10505",4.6));

        System.out.println(personalComputer);
        personalComputer.addHardware(new Hardware("RAM", "Kingston 16 GB DDR4 3200MHz"));
        personalComputer.addHardware(new Hardware("SSD", "Samsung 980 PRO 1TB m.2"));
        personalComputer.addHardware(new Hardware("VGA", "Asus RTX 3080Ti 12 GB"));

        System.out.println(personalComputer);
        personalComputer.addSoftware(new Software("Windows 10 Pro",19042.1288));
        personalComputer.addSoftware(new Software("JAVA JDK", 17));

        System.out.println(personalComputer);

        System.out.println(personalComputer.getCpu());
        System.out.println(personalComputer.getHardwares());
        System.out.println(personalComputer.getSoftwares());

        System.out.println(personalComputer.getHardwares().get(0));
        System.out.println(personalComputer.getSoftwares().get(1));
    }
}
