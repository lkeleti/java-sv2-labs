package interfacedependencyinversion.vaccine;

import java.util.ArrayList;
import java.util.List;

public class SecondVaccine implements Vaccine{
    private List<Person> vaccinationList = new ArrayList<>();

    @Override
    public List<Person> getVaccinationList() {
        return vaccinationList;
    }

    @Override
    public void generateVaccinationList(List<Person> registrated) {
        List<Person> youngers = new ArrayList<>();
        List<Person> olders = new ArrayList<>();

        for (Person actual: registrated) {
            if (!(actual.getPregnant() == Pregnancy.YES || actual.getChronic() == ChronicDisease.YES)) {
                if (actual.getAge() <= 65) {
                    youngers.add(actual);
                } else {
                    olders.add(actual);
                }
            }
        }
        vaccinationList = new ArrayList<>();
        vaccinationList.addAll(youngers);
        vaccinationList.addAll(olders);
    }
}
