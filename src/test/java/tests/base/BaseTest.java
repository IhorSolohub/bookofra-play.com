package tests.base;

import common.CommonActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import pages.artikel.ArtikelPage;
import pages.artikelCategory.ArtikelCategory;
import pages.base.BasePage;
import pages.main.MainPage;
import pages.onlineCasinos.OnlineCasinosPage;


public class BaseTest {

    public BasePage basePage;
    public MainPage mainPage;
    public ArtikelCategory artikelCategory;
    public ArtikelPage artikelPage;
    public OnlineCasinosPage onlineCasinosPage;

    public void startDriver (String browser) {
        WebDriver driver = null;
        switch (browser) {
            case "main" :
            case "artikelCategory" :
                driver = CommonActions.createDriver("CHROME", 1024, 1366);
                break;
            case "artikel" :
                driver = CommonActions.createDriver("CHROME", 360, 640);
                break;
            case "onlineCasinos" :
                driver = CommonActions.createDriver("CHROME", 1366, 1024);
                break;
        }
        basePage = new BasePage(driver);
        mainPage = new MainPage(driver);
        artikelCategory = new ArtikelCategory(driver);
        artikelPage = new ArtikelPage(driver);
        onlineCasinosPage = new OnlineCasinosPage(driver);
    }

    @AfterMethod
    public void clearCookiesAndExit () {
        basePage.clearCookiesAndLocalStorageAndClose();
    }
}
