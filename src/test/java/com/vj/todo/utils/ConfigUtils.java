package com.vj.todo.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
    private static ConfigUtils configUtils;
    private Properties properties;

    private ConfigUtils() {
        properties = readProp();
    }

    public static ConfigUtils getInstance() {
        if(configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    private Properties readProp() {
        InputStream inputStream;
        try {
            String evn = System.getProperty("env", "PRODUCTION");
            switch (evn.toUpperCase()) {
                case "PRODUCTION" -> inputStream = new FileInputStream("src/test/resources/production.properties");
                case "LOCAL" -> inputStream = new FileInputStream("src/test/resources/local.properties");
                default -> throw new RuntimeException("Env not supported");
            }
            properties = new Properties();
            properties.load(inputStream);
            System.out.println(properties.getProperty("URL"));
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
        return properties;
    }

    public String getBaseUrl() {
        return properties.get("URL").toString();
    }

}