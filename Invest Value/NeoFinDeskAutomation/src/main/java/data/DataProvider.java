package data;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * this class is used to provide data present in properties, csv, excel, text... files
 */
public class DataProvider {
    private static final String propertiesPath = "src/main/resources/Automation/UI/UIAutomation.properties";

    /**
     * This method helps in getting values of a property
     * @param key is a name of a property
     * @return property value
     */
    public static String dataProvider(String key) {
        try (InputStream input = Files.newInputStream(Paths.get(propertiesPath))) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.get(key).toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}