package ui.view;

import java.util.Properties;

/*
Create a class that extends this abstract class and name it Secret
exclude Secret form GitHub
 */
public abstract class Credentials {
    static public void setPass(Properties dbProperties) {
        dbProperties.setProperty("user", "");
        dbProperties.setProperty("password", "");
    }
}
