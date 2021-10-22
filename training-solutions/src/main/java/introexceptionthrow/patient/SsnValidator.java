package introexceptionthrow.patient;

public class SsnValidator {
    public boolean IsValidSsn(String ssn) {
        if (ssn.length() != 9)
        {
            return false;
        }

        for (char character: ssn.toCharArray()) {
            if (!Character.isDigit(character)) {
                return false;
            }
        }

        int sum = 0;

        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                sum += (Integer.parseInt(ssn.substring(i,i+1)) * 7);
            }
            else {
                sum += (Integer.parseInt(ssn.substring(i,i+1)) * 3);
            }
        }

        int ninthNumber = sum % 10;
        if (ninthNumber == Integer.parseInt(ssn.substring(8,9))) {
            return true;

        }
        else {
            return false;
        }
    }
}
