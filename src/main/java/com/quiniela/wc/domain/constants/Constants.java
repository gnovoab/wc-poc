
//Namespace
package com.quiniela.wc.domain.constants;

//Imports
import org.springframework.beans.factory.annotation.Value;

/**
 * Class that handles project constants.
 */
public class Constants {
    //CHECKSTYLE:OFF
    public static String APPLICATION_NAME;

    @Value("${spring.application.name}")
    public void setApplicationName(String applicationName) {
        APPLICATION_NAME = applicationName;
    }
    //CHECKSTYLE:ON

    public static final String TEMP_USER = "gnovoab";
}
