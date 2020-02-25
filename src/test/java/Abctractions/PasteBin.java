package Abctractions;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

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
        options.addArguments("enable-automation");
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--disable-gpu");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy("proxy.lan:3128");
//        options.setProxy(proxy);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
        driver.get(url);
    }
}
