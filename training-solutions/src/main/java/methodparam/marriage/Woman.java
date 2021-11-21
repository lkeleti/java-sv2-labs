package methodparam.marriage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Woman {
    private String name;
    private List<RegisterDate> registerDates = new ArrayList<>();

    public Woman(String name, LocalDate birthDate) {
        this.name = name;
        registerDates.add(new RegisterDate("születés ideje", birthDate));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RegisterDate> getRegisterDates() {
        return registerDates;
    }

    public void addRegisterDate(RegisterDate registerDate) {
        registerDates.add(registerDate);
    }
}
