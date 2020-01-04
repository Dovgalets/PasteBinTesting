package Tests;

import PageObjects.PasteBinHomePage;

import PageObjects.PasteBinSubmitted;
import org.assertj.core.api.SoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PasteBinHomePageTest {
    PasteBinHomePage pasteBinHomePage;

    @Before
    public void openWindow() {
        pasteBinHomePage = new PasteBinHomePage();
    }

    @Test
    public void pasteTestICanWin() {
        pasteBinHomePage.inputNewPaste("Hello from WebDriver")
                .selectionPasteExpiration(PasteBinHomePage.PasteExpiration.Minutes10)
                .inputPasteNameTitle("helloweb")
                .pressCreateNewPasteButton();
    }

    @Test
    public void pasteTestBringItOn() {
        String expectedTitle = "how to gain dominance among developers";
        String expectedBinData = "git config --global user.name  \"New Sheriff in Town\"" + "\n" + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")" + "\n" + "git push origin master --force";
        PasteBinSubmitted pasteBinSubmitted = pasteBinHomePage.inputNewPaste(expectedBinData)
                .selectionSyntaxHighlighting(PasteBinHomePage.SyntaxHighlighting.Bash)
                .selectionPasteExpiration(PasteBinHomePage.PasteExpiration.Minutes10)
                .inputPasteNameTitle(expectedTitle)
                .pressCreateNewPasteButton();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(pasteBinSubmitted.getTitle()).isEqualTo(expectedTitle);
        softAssertions.assertThat(pasteBinSubmitted.getText()).isEqualTo(expectedBinData);
        softAssertions.assertThat(pasteBinSubmitted.getClass("git")).isNotEqualTo(pasteBinSubmitted.getClass("in"));

        softAssertions.assertAll();
    }

    @After
    public void closeWindow() throws InterruptedException {
        pasteBinHomePage.closeWindow();
    }

}
