package controlselection.accents;

public class WithoutAccents {
    private final char[][] accents = {{'á','a'},{'é','e'}, {'í','i'}, {'ó','o'}, {'ö','o'}, {'ő','o'}, {'ú','u'},
            {'ü','u'},{'ű','u'}, {'Á','A'}, {'É','e'}, {'Í','I'}, {'Ó','O'}, {'Ö','O'}, {'Ő','O'}, {'Ú','U'},
            {'Ü','U'}, {'Ű','U'}};
    public char removeAccent(char character) {
        char result = character;

        for (int i = 0; i < accents.length; i++) {
            if (accents[i][0] == character) {
                result = accents[i][1];
            }
        }
        return result;
    }
}
