package catalog;

import java.util.List;

public class Validators {
    public static boolean isBlank(String text){
        return text == null || text.isEmpty();
    }

    public static boolean isEmpty(List<String> stringList){
        return stringList == null || stringList.isEmpty();
    }
}
