package tests.main;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Footer.FOOTER_TITLES;
import static constants.Constant.Footer.NUMBER_OF_GOOD_FOOTER_BUTTONS;
import static constants.Constant.Header.HEADER_TITLES;
import static constants.Constant.Header.NUMBER_OF_GOOD_HEADER_BUTTONS;
import static constants.Constant.Reg.NUMBER_OF_PLAY_FOR_REAL_MONEY_BUTTON_MAIN_PAGE;
import static constants.Constant.Reg.REG_TITLES;
import static constants.Constant.Reviews.NUMBER_OF_LAST_ARTICLES_READ_MORE_BUTTON_MAIN_PAGE;
import static constants.Constant.Reviews.REVIEW_TITLES;
import static constants.Constant.Urls.MAIN_PAGE_URL;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainTest extends BaseTest {
    @Test(invocationCount = 2, successPercentage = 99)
    public void headerButtonsTest () {
        startDriver("main");
        basePage.goToUrl(MAIN_PAGE_URL);
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
            basePage.back(MAIN_PAGE_URL);
        }
        assertEquals(NUMBER_OF_GOOD_HEADER_BUTTONS, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void footerButtonsTest () {
        startDriver("main");
        basePage.goToUrl(MAIN_PAGE_URL);
        basePage.waitOneSeconds();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_GOOD_FOOTER_BUTTONS; i++) {
            basePage.waitOneSeconds();
            basePage.footerButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(FOOTER_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(MAIN_PAGE_URL);
        }
        assertEquals(NUMBER_OF_GOOD_FOOTER_BUTTONS, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void mainLogoLinkTest () {
        startDriver("main");
        basePage.goToUrl(MAIN_PAGE_URL);
        basePage.waitOneSeconds();
        basePage.mainLogoButtonClick();
        basePage.waitOneSeconds();
        assertEquals(MAIN_PAGE_URL, basePage.getCurrentUrl());
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void umGeldSpielenOnSlotButtonTest () {
        startDriver("main");
        basePage.goToUrl(MAIN_PAGE_URL);
        basePage.waitOneSeconds();
        basePage.waitOneSeconds();
        mainPage.umGeldSpielenOnSlotButtonClick();
        basePage.nextTab();
        basePage.waitThirtySeconds();
        assertTrue(basePage.checkTitles(REG_TITLES));
        if (!basePage.checkTitles(REG_TITLES)) { basePage.outputWrongTitle(); }
        basePage.closeTabAndMoveToNext();
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void umGeldSpielenRegButtonTest () {
        startDriver("main");
        basePage.goToUrl(MAIN_PAGE_URL);
        basePage.waitOneSeconds();
        int goodTitlesCount = 0;
        for (int i = 3; i <= 4; i++) {
            basePage.waitOneSeconds();
            mainPage.umGeldSpielenRegButtonClick(i);
            basePage.nextTab();
            basePage.waitThirtySeconds();
            if (basePage.checkTitles(REG_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.closeTabAndMoveToNext();
        }
        assertEquals(NUMBER_OF_PLAY_FOR_REAL_MONEY_BUTTON_MAIN_PAGE, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void lezteArtikelWeiterLessenButtonTest () {
        startDriver("main");
        basePage.goToUrl(MAIN_PAGE_URL);
        basePage.waitOneSeconds();
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_LAST_ARTICLES_READ_MORE_BUTTON_MAIN_PAGE; i++) {
            basePage.waitOneSeconds();
            mainPage.lezteArtikelWeiterLessenButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(MAIN_PAGE_URL);
        }
        assertEquals(NUMBER_OF_LAST_ARTICLES_READ_MORE_BUTTON_MAIN_PAGE, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void readMoreCommentsButtonTest () {
        startDriver("main");
        basePage.goToUrl(MAIN_PAGE_URL);
        basePage.waitOneSeconds();
        basePage.waitTwoSeconds();
        mainPage.readMoreCommentsButtonClick();
        basePage.waitTwoSeconds();
        assertTrue(mainPage.commentCheck());
    }

}
