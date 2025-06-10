package com.vj.todo.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("src/test/resources/local.properties");
        Properties properties = new Properties();
        properties.load(is);
        System.out.println(properties.getProperty("URL"));
    }
}
