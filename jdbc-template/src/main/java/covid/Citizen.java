package covid;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Citizen {
    private String taj;
    private int numberOfVaccination;
    private LocalDateTime lastVaccinationDate;
    private List<Vaccination> vaccinations = new ArrayList<>();

    public Citizen(String taj, int numberOfVaccination, LocalDateTime lastVaccinationDate) {
        this.taj = taj;
        this.numberOfVaccination = numberOfVaccination;
        this.lastVaccinationDate = lastVaccinationDate;
    }

    public String getTaj() {
        return taj;
    }

    public int getNumberOfVaccination() {
        return numberOfVaccination;
    }

    public LocalDateTime getLastVaccinationDate() {
        return lastVaccinationDate;
    }

    public List<Vaccination> getVaccinations() {
        return new ArrayList<>(vaccinations);
    }

    public void addVaccination(Vaccination vaccination) {
        vaccinations.add(vaccination);
    }
}
