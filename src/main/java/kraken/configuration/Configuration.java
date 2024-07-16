package kraken.configuration;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class Configuration {

    static JsonSettingsFile jsonSettingsFile = new JsonSettingsFile("config.json");
    static ISettingsFile environment = new JsonSettingsFile("settings.json");

    public static String startUrl = jsonSettingsFile.getValue("/startUrl").toString();
}
