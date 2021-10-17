package stringconcat.nameconcat;

public class NameMain {
    public static void main(String[] args) {
        Name name1 = new Name("Kis", "", "Géza");
        System.out.println(name1.concatNameWesternStyle());
        System.out.println(name1.concatNameHungarianStyle());

        Name name2 = new Name("Kis", "István", "Géza");
        System.out.println(name2.concatNameWesternStyle());
        System.out.println(name2.concatNameHungarianStyle());

        Name name3 = new Name( "Kis", "István", "Géza", Title.Dr);
        System.out.println(name3.concatNameWesternStyle());
        System.out.println(name3.concatNameHungarianStyle());
    }
}
