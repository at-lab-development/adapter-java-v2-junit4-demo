package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.pages.DriverManager;

public class YoutubePage {

    private final DriverManager driverManager = DriverManager.getInstance();

    @FindBy(className = "title")
    private WebElement videoTitle;

    @FindBy(id = "owner-name")
    private WebElement authorName;

    public YoutubePage(String URL) {
        PageFactory.initElements(driverManager.getDriver(), this);
        driverManager.open(URL);
    }

    public String getVideoTitle() {
        driverManager.waitUntilVisible(videoTitle);
        return videoTitle.getText();
    }

    public String getAuthorName() {
        driverManager.waitUntilVisible(authorName);
        return authorName.getText();
    }
}

