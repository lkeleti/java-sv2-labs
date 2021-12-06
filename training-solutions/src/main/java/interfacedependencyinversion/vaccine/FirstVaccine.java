package interfacedependencyinversion.vaccine;

import java.util.ArrayList;
import java.util.List;

public class FirstVaccine implements Vaccine{

    private List<Person> vaccinationList = new ArrayList<>();
    @Override
    public List<Person> getVaccinationList() {
        return vaccinationList;
    }

    @Override
    public void generateVaccinationList(List<Person> registrated) {
        List<Person> pregnants = new ArrayList<>();
        List<Person> olders = new ArrayList<>();
        List<Person> anyBody = new ArrayList<>();

        for (Person actual: registrated) {
            if (actual.getPregnant() == Pregnancy.YES) {
                pregnants.add(actual);
            }
            else if (actual.getAge() > 65) {
                olders.add(actual);
            }
            else {
                anyBody.add(actual);
            }
        }
        vaccinationList = new ArrayList<>();
        vaccinationList.addAll(pregnants);
        vaccinationList.addAll(olders);
        vaccinationList.addAll(anyBody);
    }
}
