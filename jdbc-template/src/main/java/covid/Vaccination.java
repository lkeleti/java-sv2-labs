package covid;

import java.time.LocalDateTime;

public class Vaccination {

    private LocalDateTime vaccinationDate;
    private String status;
    private String note;
    private VaccinationType vaccinationType;

    public Vaccination(LocalDateTime vaccinationDate, String status, String note, VaccinationType vaccinationType) {
        this.vaccinationDate = vaccinationDate;
        this.status = status;
        this.note = note;
        this.vaccinationType = vaccinationType;
    }

    public LocalDateTime getVaccinationDate() {
        return vaccinationDate;
    }

    public String getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public VaccinationType getVaccinationType() {
        return vaccinationType;
    }
}
