package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurrenciesUtils {

    public static double extractAmount(String value) {
        String regex = "[\\d,.]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        if (matcher.find()) {
            String numberString = matcher.group();
            numberString = numberString.replace(",", "");
            return Double.parseDouble(numberString);
        }

        throw new IllegalArgumentException("No numeric value found in the input string: " + value);
    }
}
