package sorting;

import java.util.Comparator;

public class PatientComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient o1, Patient o2) {
        return o1.getDateTime().compareTo(o2.getDateTime());
    }
}
