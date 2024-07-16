package utilities;

public class CurrenciesUtils {

    public static String cleanDollarSignPrefix(String value){
        return value.replaceAll("\\$", "");
    }
}
