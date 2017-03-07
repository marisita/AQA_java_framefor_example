package com.epam.mariia_lavrova.property;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * Class for properties management
 *
 * @author Mariia_Lavrova
 * @since 02/02/2017
 */
public class PropertyFactory {

    private static final Logger LOGGER = LogManager.getLogger(PropertyFactory.class);
    private static final String PROPERTIES_FILE = "src/main/resources/property/app.properties";
    private static Properties properties;

    /**
     * Create an instance of Properties and read them from property file
     * @return properties instance
     */
    public static Properties getInstance(){
        properties = new Properties();
        InputStream is = null;
        try {
            is = new FileInputStream(PROPERTIES_FILE);
            properties.load(is);
            is.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return properties;
    }

    /**
     * Return a property from property file using propertyName
     * @param propertyName name of property from property file
     * @return appropriate property
     */
    public static String getProperty(String propertyName) {
        getInstance();
        return properties.getProperty(propertyName);
    }

    /**
     * Set a property value
     * @param propertyName name of property from property file
     * @param value to set into property
     */
    public static void setProperty(String propertyName, String value) {
        getInstance();
        properties.setProperty(propertyName, value);
        storeProperty();
    }

    /**
     * Save a property to the property file
     */
    public static void storeProperty() {
        try {
            FileOutputStream prop = new FileOutputStream(PROPERTIES_FILE);
            properties.store(prop, null);
            prop.flush();
            prop.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
