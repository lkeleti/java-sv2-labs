package covid;

public class PersonValidator {

    public String lastNumberOfTaj(String taj) {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            int actual = Integer.parseInt(taj.substring(i,i+1));
            if (i % 2 == 0) {
                actual = actual * 3;
            }
            else {
                actual = actual * 7;
            }
            sum += actual;
        }
        return String.valueOf(sum % 10);
    }

    public boolean isValidTaj(String taj) {
        return taj.substring(8,9).equals(lastNumberOfTaj(taj));
    }

    public boolean isValidName(String name) {
        return isEmpty(name);
    }

    public boolean isValidZip(String zip) {
        return isEmpty(zip);
    }

    public boolean isValidEmail(String email) {
        return email.contains("@") &&
                !email.startsWith("@") &&
                !email.endsWith("@") &&
                isEmpty(email);
    }

    private boolean isEmpty(String value) {
        return !(value == null || value.isBlank() || value.isEmpty());
    }

    public boolean isValidAge(int age) {
        return (age > 10 && age < 150);
    }
}
