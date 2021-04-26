package platform.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilities {

    public String getProperty(String property){
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("src/test/resources/setupTest/setup-config.properties"));
            return prop.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return property;
    }
}
