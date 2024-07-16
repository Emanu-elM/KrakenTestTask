package kraken.configuration;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class Configuration {

    static JsonSettingsFile jsonSettingsFile = new JsonSettingsFile("config.json");

    public static String startUrl = jsonSettingsFile.getValue("/startUrl").toString();
    public static String apiUrl = jsonSettingsFile.getValue("/apiUrl").toString();
}
