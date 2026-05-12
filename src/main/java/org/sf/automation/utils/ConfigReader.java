package org.sf.automation.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties props = new Properties();

    static {
        try {
            props.load(new FileInputStream(
                    "src/test/resources/config.properties"));
        } catch (Exception e) {
            throw new RuntimeException("config.properties not found", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
