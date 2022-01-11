package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedicalSurgery {
    private List<Patient> patients;

    public MedicalSurgery(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Patient> getPatientsInTimeOrder() {
        List<Patient> result = new ArrayList<>(patients);
        Collections.sort(result,new PatientComparator());
        return result;
    }
}
