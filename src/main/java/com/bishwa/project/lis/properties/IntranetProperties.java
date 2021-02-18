package com.bishwa.project.lis.properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

/**
 * Author: Bishwa
 * Date: 18/02/2021
 * Time: 23:30
 */
public enum IntranetProperties {

    INTRANET_USERNAME("INTRANET_USERNAME"),
    INTRANET_PASSWORD("INTRANET_PASSWORD");

    private static final Logger logger = LogManager.getLogger(IntranetProperties.class);
    private static final Properties intranetProperties = new Properties();
    private static final String PROPERTIES_FILE = "intranet.properties";

    static {
        try {
            intranetProperties.load(IntranetProperties.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
        } catch (Exception e) {
            logger.error("Failed to load Intranet Properties file " + e.getMessage());
        }
    }

    private final String key;

    private IntranetProperties(String key) {
        this.key = key;
    }

    public String val() {
        return intranetProperties.getProperty(key, "");
    }
}
