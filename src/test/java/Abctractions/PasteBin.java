package Abctractions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class PasteBin {
    public final static WebDriver driver = new ChromeDriver();

    public PasteBin() {
    }

    public PasteBin(String url) {
        driver.get(url);
    }
}
