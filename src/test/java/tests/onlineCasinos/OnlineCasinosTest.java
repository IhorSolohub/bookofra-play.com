package tests.onlineCasinos;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Footer.FOOTER_TITLES;
import static constants.Constant.Footer.NUMBER_OF_GOOD_FOOTER_BUTTONS;
import static constants.Constant.Header.HEADER_TITLES;
import static constants.Constant.Header.NUMBER_OF_GOOD_HEADER_BUTTONS;
import static constants.Constant.Reg.NUMBER_OF_UBERSICHT_BUTTON_ONLINE_CASINOS_PAGE;
import static constants.Constant.Reg.REG_TITLES;
import static constants.Constant.Urls.MAIN_PAGE_URL;
import static constants.Constant.Urls.ONLINE_CASINOS_PAGE_URL;
import static org.testng.Assert.assertEquals;

public class OnlineCasinosTest extends BaseTest {

    @Test(invocationCount = 2, successPercentage = 99)
    public void headerButtonsTest () {
        startDriver("onlineCasinos");
        basePage.goToUrl(ONLINE_CASINOS_PAGE_URL);
        basePage.waitOneSeconds();
        basePage.closePopup();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_GOOD_HEADER_BUTTONS; i++) {
            basePage.waitOneSeconds();
            basePage.headerOpenClick();
            basePage.waitOneSeconds();
            basePage.headerButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(HEADER_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(ONLINE_CASINOS_PAGE_URL);
        }
        assertEquals(NUMBER_OF_GOOD_HEADER_BUTTONS, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void footerButtonsTest () {
        startDriver("onlineCasinos");
        basePage.goToUrl(ONLINE_CASINOS_PAGE_URL);
        basePage.waitOneSeconds();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_GOOD_FOOTER_BUTTONS; i++) {
            basePage.waitOneSeconds();
            basePage.footerButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(FOOTER_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(ONLINE_CASINOS_PAGE_URL);
        }
        assertEquals(NUMBER_OF_GOOD_FOOTER_BUTTONS, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void mainLogoLinkTest () {
        startDriver("onlineCasinos");
        basePage.goToUrl(ONLINE_CASINOS_PAGE_URL);
        basePage.waitOneSeconds();
        basePage.closePopup();
        basePage.mainLogoButtonClick();
        basePage.waitOneSeconds();
        assertEquals(MAIN_PAGE_URL, basePage.getCurrentUrl());
    }

    /*
    @Test(invocationCount = 2, successPercentage = 99)
    public void ubersichtRegButtonTest () {
        startDriver("onlineCasinos");
        basePage.goToUrl(ONLINE_CASINOS_PAGE_URL);
        basePage.waitOneSeconds();
        basePage.closePopup();
        basePage.waitThirtySeconds();
        onlineCasinosPage.closeSecondPopupClick();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_UBERSICHT_BUTTON_ONLINE_CASINOS_PAGE; i++) {
            basePage.waitTwoSeconds();
            onlineCasinosPage.ubersichtRegButtonClick(i);
            basePage.nextTab();
            basePage.waitThirtySeconds();
            if (basePage.checkTitles(REG_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.closeTabAndMoveToNext();
        }
        assertEquals(NUMBER_OF_UBERSICHT_BUTTON_ONLINE_CASINOS_PAGE, goodTitlesCount);
    }

     */

}
