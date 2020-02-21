package Abctractions;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class PasteBin {
    static {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
    }
    public static WebDriver driver;

    public PasteBin() {
    }

    public PasteBin(String url) {
//        this();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("disable-gpu");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("Jenkins Testing!!!");
    }
}
