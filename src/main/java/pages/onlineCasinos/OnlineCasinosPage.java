package pages.onlineCasinos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class OnlineCasinosPage extends BasePage {

    public OnlineCasinosPage(WebDriver driver) {super(driver);}

    private final By closeSecondPopup = By.xpath("//button[@class='c-universal-popup__close']");

    public OnlineCasinosPage closeSecondPopupClick () {
        driver.findElement(closeSecondPopup).click();
        return this;
    }

    public OnlineCasinosPage ubersichtRegButtonClick(int numButton) {
        By ubersichtRegButton = By.xpath("(//a[contains(@class,'rev')])[" + numButton + "]");
        driver.findElement(ubersichtRegButton).click();
        return this;
    }

}
