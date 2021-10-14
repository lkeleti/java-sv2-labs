package composition.realestate;

public class RealEstateDotCom {
    public static void main(String[] args) {
        Address address = new Address("Zalaegerszeg","1234",
                "Fő út",5);
        Details details = new Details("3 szobás és 2 fürdőszobás",
                address,100, 1000);
        RealEstate realEstate = new RealEstate("Családi ház eladó",
                25_000_000, details);

        System.out.println(realEstate.toString());
    }
}
