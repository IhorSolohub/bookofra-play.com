package pages.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {super(driver);}

    private final By umGeldSpielenOnSlotRegButton = By.xpath("//a[@class='c-double-btn__link']");
    private final By readMoreCommentsButton = By.xpath("//a[@class='more_comments show_el']");
    private final By comment = By.xpath("(//div[@class='comment even thread-even depth-1 open box_comment st_field'])[3]");

    public MainPage umGeldSpielenOnSlotButtonClick() {
        driver.findElement(umGeldSpielenOnSlotRegButton).click();
        return this;
    }

    public MainPage umGeldSpielenRegButtonClick(int numButton) {
        By umGeldSpielen = By.xpath("(//a[contains(@class,'btn btn_2')])[" + numButton + "]");
        driver.findElement(umGeldSpielen).click();
        return this;
    }

    public MainPage lezteArtikelWeiterLessenButtonClick(int numButton) {
        By lezteArtikelWeiterLessenButton = By.xpath("(//a[contains(@class,'c-one-blog__btn')])[" + numButton + "]");
        driver.findElement(lezteArtikelWeiterLessenButton).click();
        return this;
    }

    public MainPage readMoreCommentsButtonClick () {
        driver.findElement(readMoreCommentsButton).click();
        return this;
    }

    public boolean commentCheck () {
        return elementVisibleCheck(comment);
    }

}
