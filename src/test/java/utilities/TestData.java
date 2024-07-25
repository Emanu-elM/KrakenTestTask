package utilities;

import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestData {
    static JsonSettingsFile jsonSettingsFile = new JsonSettingsFile("testData.json");

    public static String getStringValue(String data) {
        return jsonSettingsFile.getValue("/"+data).toString();
    }

    public static Integer getNumericValue(String data) {
        return (Integer) jsonSettingsFile.getValue("/"+data);
    }
}
