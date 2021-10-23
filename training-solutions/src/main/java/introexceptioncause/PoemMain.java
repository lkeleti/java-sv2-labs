package introexceptioncause;

public class PoemMain {
    public static void main(String[] args) {
        Poem poem = new Poem();
        System.out.println(poem.getFirstChars("poem.txt"));
    }
}
