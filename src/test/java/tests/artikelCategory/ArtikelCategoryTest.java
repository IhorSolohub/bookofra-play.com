package tests.artikelCategory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Footer.FOOTER_TITLES;
import static constants.Constant.Footer.NUMBER_OF_GOOD_FOOTER_BUTTONS;
import static constants.Constant.Header.HEADER_TITLES;
import static constants.Constant.Header.NUMBER_OF_GOOD_HEADER_BUTTONS;
import static constants.Constant.Reviews.NUMBER_OF_ARTIKEL_BUTTON_MAIN_PAGE;
import static constants.Constant.Reviews.REVIEW_TITLES;
import static constants.Constant.Urls.*;
import static org.testng.Assert.assertEquals;

public class ArtikelCategoryTest extends BaseTest {

    @BeforeMethod
    public void setUp () {
        startDriver("artikelCategory");
        basePage.goToUrl(ARTIKEL_CATEGORY_URL);
        basePage.waitOneSeconds();
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void headerButtonsTest () {
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
            basePage.back(ARTIKEL_CATEGORY_URL);
        }
        assertEquals(NUMBER_OF_GOOD_HEADER_BUTTONS, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void footerButtonsTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_GOOD_FOOTER_BUTTONS; i++) {
            basePage.waitOneSeconds();
            basePage.footerButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(FOOTER_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(ARTIKEL_CATEGORY_URL);
        }
        assertEquals(NUMBER_OF_GOOD_FOOTER_BUTTONS, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void mainLogoLinkTest () {
        basePage.mainLogoButtonClick();
        basePage.waitOneSeconds();
        assertEquals(MAIN_PAGE_URL, basePage.getCurrentUrl());
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void weiterLessenButtonTest () {
        int goodTitlesCount = 0;
        for (int i = 1; i <= NUMBER_OF_ARTIKEL_BUTTON_MAIN_PAGE; i++) {
            basePage.waitOneSeconds();
            artikelCategory.weiterLessenButtonClick(i);
            basePage.waitOneSeconds();
            if (basePage.checkTitles(REVIEW_TITLES)) { goodTitlesCount++; }
            else { basePage.outputWrongTitle(); }
            basePage.back(ARTIKEL_CATEGORY_URL);
        }
        assertEquals(NUMBER_OF_ARTIKEL_BUTTON_MAIN_PAGE, goodTitlesCount);
    }

    @Test(invocationCount = 2, successPercentage = 99)
    public void nextPageButtonTest () {
        basePage.waitTwoSeconds();
        artikelCategory.nextPageButtonClick();
        basePage.waitTwoSeconds();
        assertEquals(ARTIKEL_CATEGORY_SECOND_PAGE_URL, basePage.getCurrentUrl());
    }

}
