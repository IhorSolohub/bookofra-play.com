package pages.artikelCategory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class ArtikelCategory extends BasePage {

    public ArtikelCategory(WebDriver driver) {super(driver);}

    private final By nextPageButton = By.xpath("//li[@class='nav-box__it nav-box__it--next']");

    public ArtikelCategory nextPageButtonClick () {
        driver.findElement(nextPageButton).click();
        return this;
    }

    public ArtikelCategory weiterLessenButtonClick(int numButton) {
        By weiterLessen = By.xpath("(//a[contains(@class,'c-one-blog__btn')])[" + numButton + "]");
        driver.findElement(weiterLessen).click();
        return this;
    }

}
