package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class Utils {


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
