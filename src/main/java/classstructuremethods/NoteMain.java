package classstructuremethods;

public class NoteMain {
    public static void main(String[] args) {
        Note note = new Note();
        note.setName("Keleti László");
        note.setTopic("JAVA programozás");
        note.setText("Most kezdtük, de már az ostályoknál járunk");

        System.out.println(note.getNoteText());

    }
}
