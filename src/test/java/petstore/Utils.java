package petstore;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<String> splitStringToList(String value){
        return Arrays.asList(value.split(","));
    }
}
