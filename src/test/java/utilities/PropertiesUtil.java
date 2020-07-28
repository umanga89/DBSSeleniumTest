package utilities;

import java.io.*;
import java.util.Properties;

public class PropertiesUtil {

    static Properties configProperties = new Properties();
    public static Properties loadProperties(String url) throws IOException {
        try {
            File configPropertiesFile = new File(url);
            FileInputStream inputStream = new FileInputStream(configPropertiesFile);
            configProperties.load(inputStream);

        }catch (IOException e) {
            e.printStackTrace();
        }
        return configProperties;
    }
}
