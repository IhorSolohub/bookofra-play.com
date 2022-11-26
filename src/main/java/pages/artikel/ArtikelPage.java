package pages.artikel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ArtikelPage extends BasePage {

    public ArtikelPage(WebDriver driver) {super(driver);}

    private final By nameInput = By.xpath("//input[@id='author']");
    private final By emailInput= By.xpath("//input[@id='email']");
    private final By commentIInput = By.xpath("//textarea[@id='comment']");
    private final By sendButton = By.xpath("//input[@id='submit_button']");
    private final By submitMessage = By.xpath("//div[@id='form-message']");


    public ArtikelPage weiterLessenButtonClick(int numButton) {
        By weiterLessenButton = By.xpath("(//a[contains(@class,'c-one-blog__btn')])[" + numButton + "]");
        driver.findElement(weiterLessenButton).click();
        return this;
    }

    public ArtikelPage enterName (String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public ArtikelPage enterEmail (String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public ArtikelPage enterComment (String comment) {
        driver.findElement(commentIInput).sendKeys(comment);
        return this;
    }

    public ArtikelPage submitButtonClick () {
        driver.findElement(sendButton).click();
        return this;
    }

    public Boolean submitMessageVisibleCheck () {
        return elementVisibleCheck(submitMessage);
    }

}
