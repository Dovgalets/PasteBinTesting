package PageObjects;

import Abctractions.PasteBin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PasteBinSubmitted extends PasteBin {
    public PasteBinSubmitted() {
        super();
    }

    public String getTitle() {
        return driver.findElement(By.className("paste_box_line1")).getText();
    }

    public String getText() {
        return driver.findElement(By.id("paste_code")).getText();
    }

    public String getClass(String text) {
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectable\"]/ol/li/div/span[contains(text(),'" + text + "')]"));
        String className = list.get(0).getAttribute("class");
        for (WebElement webElement : list) {
            if (!className.equals(webElement.getAttribute("class"))) {
                className = null;
                break;
            }
        }
        return className;
    }
}
