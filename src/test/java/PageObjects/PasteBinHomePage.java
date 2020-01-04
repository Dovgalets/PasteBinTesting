package PageObjects;

import Abctractions.PasteBin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;

public class PasteBinHomePage extends PasteBin {

    public enum PasteExpiration {Never, Minutes10, Hour1, Day1, Week1, Weeks2, Month1, Months6, Year1}

    public enum SyntaxHighlighting {None, Bash, C, CSharp, CPlusPlus, CSS, HTML, Java, JavaScript, JSON}

    public PasteBinHomePage() {
        super("https://pastebin.com/");
    }

    public PasteBinHomePage inputNewPaste(String newPaste) {
        WebElement fieldNewPaste = driver.findElement(By.name("paste_code"));
        fieldNewPaste.sendKeys(newPaste);
        return this;
    }

    private CharSequence[] getArrowDownSequence(int size) {
        CharSequence[] arrowDownSequence = new CharSequence[size];
        for (int i = 0; i < arrowDownSequence.length; i++) {
            arrowDownSequence[i] = Keys.ARROW_DOWN;
        }
        return arrowDownSequence;
    }

    public PasteBinHomePage selectionPasteExpiration(PasteExpiration expiration) {
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//span[text()='Never']"))).click()
                .sendKeys(getArrowDownSequence(expiration.ordinal()))
                .sendKeys(Keys.ENTER)
                .build().perform();
        return this;
    }

    public PasteBinHomePage inputPasteNameTitle(String name) {
        WebElement fieldPasteName = driver.findElement(By.name("paste_name"));
        fieldPasteName.sendKeys(name);
        return this;
    }

    public PasteBinSubmitted pressCreateNewPasteButton() {
        WebElement buttonCreateNewPaste = driver.findElement(By.name("submit"));
        buttonCreateNewPaste.click();

        return new PasteBinSubmitted();
    }

    public PasteBinHomePage selectionSyntaxHighlighting(SyntaxHighlighting syntax) {
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//span[text()='None']"))).click().
                sendKeys(getArrowDownSequence(syntax.ordinal()))
                .sendKeys(Keys.ENTER)
                .build().perform();
        return this;
    }

    public void closeWindow() {
        driver.quit();

    }

}
