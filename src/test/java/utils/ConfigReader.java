package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    /**
     * Loads configuration from config.properties file.
     */
    public static Properties initProperties() {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**
     * Returns the value of the given property key.
     * @param key Property key
     * @return Property value
     */
    public static String getProperty(String key) {
        if (prop == null) {
            initProperties();
        }
        return prop.getProperty(key); 
    }
}