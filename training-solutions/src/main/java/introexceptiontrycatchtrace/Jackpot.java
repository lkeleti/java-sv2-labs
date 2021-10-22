package introexceptiontrycatchtrace;

public class Jackpot {
    public static void main(String[] args) {
        Winner winner = new Winner();
        winner.addPeople("Scarlett Johansson");
        winner.addPeople("Jennifer Lawrence");
        winner.addPeople("Emma Watson");
        winner.addPeople(null);
        winner.addPeople("Anne Hathaway");
        winner.addPeople("Natalie Portman");
        winner.addPeople("Emma Stone");
        winner.addPeople(null);
        winner.addPeople("Gal Gadot");
        winner.addPeople("Alexandra Daddario");
        try {
            System.out.println("A győztes: " + winner.getWinner());
        }
        catch (NullPointerException npe) {
            System.out.println("null érték került rögzítésre a nevek között!");
            System.out.println(npe.getMessage());
        }
    }
}
