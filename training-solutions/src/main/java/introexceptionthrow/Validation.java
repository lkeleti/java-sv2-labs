package introexceptionthrow;

public class Validation {
    public void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Nem adott meg nevet!");
        }
    }

    public void validateAge(String ageString) {
        if (ageString == null || ageString.isEmpty()) {
            throw new IllegalArgumentException("Nem adott meg életkort!");
        }

        boolean isNumber = true;
        for (char item: ageString.toCharArray()) {
            if (!Character.isDigit(item)) {
                throw new IllegalArgumentException("A beírt adatok között nem csak számokat adott meg!");
            }
        }

        if (Integer.parseInt(ageString) <0 || Integer.parseInt(ageString) > 120) {
            throw new IllegalArgumentException("Nem valós életkort adott meg!!");
        }
    }
}
