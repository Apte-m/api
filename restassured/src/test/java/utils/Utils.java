package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
    protected static Properties properties = new Properties();

    public static void getProperties() {
        try (InputStream output = new FileInputStream("src/test/resources/application.properties")) {
            properties.load(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static byte[] getContent() {
        byte[] image = new byte[0];
        try {
            image = FileUtils.readFileToByteArray(new File("src/test/resources/images.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;

    }
}
