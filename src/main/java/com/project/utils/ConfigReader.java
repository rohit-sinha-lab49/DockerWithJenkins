package com.project.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    public static Properties readPropertiesFile(String fileName) {
        Properties properties = new Properties ();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config/"+fileName)){
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return properties;
    }

}

