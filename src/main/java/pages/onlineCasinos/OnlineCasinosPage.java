package pages.onlineCasinos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class OnlineCasinosPage extends BasePage {

    public OnlineCasinosPage(WebDriver driver) {super(driver);}

    public OnlineCasinosPage ubersichtRegButtonClick(int numButton) {
        By ubersichtRegButton = By.xpath("(//a[contains(@class,'rev')])[" + numButton + "]");
        driver.findElement(ubersichtRegButton).click();
        return this;
    }

}
