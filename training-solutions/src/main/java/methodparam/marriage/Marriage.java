package methodparam.marriage;

import java.time.LocalDate;

public class Marriage {

    public void  getMarried(Woman woman, Man man) {
        RegisterDate registerDate = new RegisterDate("házasságkötés ideje", LocalDate.now());
        woman.addRegisterDate(registerDate);
        man.addRegisterDate(registerDate);
        woman.setName(man.getName() + "né");
    }
}
