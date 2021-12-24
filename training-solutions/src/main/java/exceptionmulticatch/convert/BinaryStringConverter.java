package exceptionmulticatch.convert;

public class BinaryStringConverter {
    public boolean[] binaryStringToBooleanArray(String binaryString) {
        checkIsNull(binaryString);
        boolean[] result = new boolean[binaryString.length()];
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '0' || binaryString.charAt(i) == '1') {
                result[i] = binaryString.charAt(i) != '0';
            }
            else {
                throw new IllegalArgumentException("Binary string is not valid.");
            }
        }
        return result;
    }

    public String booleanArrayToBinaryString(boolean[] booleans) {
        checkIsNull(booleans);
        StringBuilder sb = new StringBuilder();
        for (boolean b : booleans) {
            sb.append(b ? "1" : "0");
        }
        return sb.toString();
    }

    private void checkIsNull(String binaryString) {
        if (binaryString == null || binaryString.isEmpty()) {
            throw new NullPointerException("Binary string is null.");
        }
    }

    private void checkIsNull(boolean[] booleans) {
        if (booleans == null) {
            throw new NullPointerException("Boolean array is null.");
        }
        if (booleans.length == 0) {
            throw new IllegalArgumentException("Boolean array is empty.");
        }
    }
}
