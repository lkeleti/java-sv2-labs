package collectionsequalshash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegistryCourt {
    public static void main(String[] args) {
        List<Company> companys = new ArrayList<>(Arrays.asList(
                new Company("Jack Doe Ltd.","AAA-000-111-222"),
                new Company("Jane Doe Ltd.","AAA-000-111-333"),
                new Company("Joe Doe Ltd.","AAA-000-111-444")
        ));

        System.out.println(companys.contains(new Company("Jane Doe Ltd.","AAA-000-111-333")));
        System.out.println(companys.contains(new Company("Jane Doe Ltd.","AAA-000-111-334")));
        System.out.println(companys.contains(new Company("Jane Doe Ltd","AAA-000-111-333")));
    }
}
