package formatlocaleprintf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Run {
    private String name;
    private List<Double> kms;

    public Run(String name) {
        this.name = name;
        kms  = new ArrayList<>();
    }

    public void addRun(double km) {
        kms.add(km);
    }

    private double kmsSum() {
        Double sumOfKms = 0.0;
        for (Double km: kms) {
            sumOfKms += km;
        }
        return  sumOfKms;
    }

    public String printFormattedRunText() {

        String result;
        result = String.format("Kedves %s! %nA mai dátum: %s. %nEzen a héten ez a(z) %d. futásod. %n" +
                "Most %.1f km-t futottál. %nAz edzésnapló szerint eddig összesen %.1f km-t futottál. %nCsak így tovább!", name, LocalDate.now().toString(), kms.size(), kms.get(kms.size()-1), kmsSum());
        return result;
    }

    public static void main(String[] args) {
        Run run = new Run("Kiss Béla");
        run.addRun(15.8);
        run.addRun(11.7);
        run.addRun(10.3);
        run.addRun(12.8);
        System.out.println(run.printFormattedRunText());
    }

}
