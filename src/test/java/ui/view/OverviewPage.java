package ui.view;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class OverviewPage extends Page {

    public OverviewPage(WebDriver driver) {
        super(driver);
        this.driver.get(Config.BASE_URL + "Web3_war_exploded/Controller?command=Overview");
    }

    public boolean containsUserWithName(String name) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(name)) {
                found = true;
            }
        }
        return found;
    }

    public boolean containsUserWithRole(String name, String role) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("tr"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(name)) {
                listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
                for (WebElement rowItem : listItems) {
                    if (rowItem.getText().contains(role)) {
                        found = true;
                    }
                }
            }
        }
        return found;
    }
}
