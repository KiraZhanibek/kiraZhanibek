package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    //reader of proporties file
    public static String fileReader(String key) throws IOException {
        File credsFile = new File("src/test/resources/conf/Configuration.properties");
        //read from file
        FileReader fileReader = new FileReader(credsFile);

        Properties proporties = new Properties();

        proporties.load(fileReader);
        return proporties.getProperty(key);
    }
}


