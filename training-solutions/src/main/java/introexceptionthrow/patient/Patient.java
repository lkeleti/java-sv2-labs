package introexceptionthrow.patient;

public class Patient {
    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("A név nem lehet üres!");
        }

        if (yearOfBirth < 1900) {
            throw new IllegalArgumentException("Nem megfelelő értéket adott meg!");
        }

        SsnValidator ssnValidator = new SsnValidator();
        if (!ssnValidator.IsValidSsn(socialSecurityNumber)) {
            throw new IllegalArgumentException("Hibás TAJ számot adott meg!");
        }

        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
