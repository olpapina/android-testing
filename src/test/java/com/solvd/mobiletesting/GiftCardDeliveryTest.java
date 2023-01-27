package com.solvd.mobiletesting;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.mobiletesting.android.page.HomePage;
import com.solvd.mobiletesting.base.element.LocationPopUpBase;
import com.solvd.mobiletesting.base.element.MenuBarBase;
import com.solvd.mobiletesting.base.element.SearchBoxBase;
import com.solvd.mobiletesting.base.page.*;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class GiftCardDeliveryTest implements IAbstractTest {

    @Test(testName = "verify that delivery is impossible to Belarus")
    public void verifyDeliveryImpossibleLocationMessageTest() {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        LocationPopUpBase locationPopUp = homePage.getLocationPopUp();
        locationPopUp.clickNotChangeButton();
        String actualLocation = homePage.getActualDeliveryLocation();
        Assert.assertEquals(actualLocation, R.TESTDATA.get("impossibleDelivery"), "The location is not "+ R.TESTDATA.get("impossibleDelivery"));
        MenuBarBase menuBar = homePage.getMenuBar();
        GiftCardPageBase giftCardPage = menuBar.clickGiftCardTabButton();
        giftCardPage.clickOccasionButton();
        ResultPageBase resultPage = giftCardPage.clickTypeOfCard("MAIL");
        List<String> messages = resultPage.getValidationMessages();

        SoftAssert softAssert = new SoftAssert();
        messages.forEach(resultText -> softAssert.assertEquals(resultText, R.TESTDATA.get("validationMessage"), "Validation message is missing or text is incorrect"));
        softAssert.assertAll();
    }

    @Test(testName = "verify that click Add to cart is impossible from Belarus")
    public void verifyImpossibleClickAddToCartButton() {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        LocationPopUpBase locationPopUp = homePage.getLocationPopUp();
        locationPopUp.clickNotChangeButton();
        String actualLocation = homePage.getActualDeliveryLocation();
        Assert.assertEquals(actualLocation, R.TESTDATA.get("impossibleDelivery"), "The location is not "+ R.TESTDATA.get("impossibleDelivery"));
        MenuBarBase menuBar = homePage.getMenuBar();
        GiftCardPageBase giftCardPage = menuBar.clickGiftCardTabButton();
        giftCardPage.clickOccasionButton();
        ResultPageBase resultPage = giftCardPage.clickTypeOfCard("MAIL");
        List<Boolean> statuses = resultPage.checkButtonStatus();

        SoftAssert softAssert = new SoftAssert();
        statuses.forEach(resultText -> softAssert.assertTrue(resultText, "Button is active"));
        softAssert.assertAll();
    }

    @Test(testName = "verify that delivery is possible to US with zip code")
    public void verifyDeliveryPossibleLocationTest() throws InterruptedException {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        LocationPopUpBase locationPopUp = homePage.getLocationPopUp();
        SelectLocationPageBase selectLocationPage = locationPopUp.clickChangeAddressButton();
        EnterZipCodePageBase enterZipCodePage = selectLocationPage.clickEnterZipCodeButton();
        enterZipCodePage.enterZipCode();
        enterZipCodePage.clickApplyButton();
        homePage = new HomePage(getDriver());
        String actualLocation = homePage.getActualDeliveryLocation();
        Assert.assertEquals(actualLocation, R.TESTDATA.get("possibleDelivery") +" "+ R.TESTDATA.get("zipCode"), "The location is not zip code: "+ R.TESTDATA.get("zipCode"));
        SearchBoxBase searchBox = homePage.getSearchBox();
        searchBox.typeSearchedProduct();
        ResultSearchPageBase resultSearchPage = searchBox.clickSearchButton();
        ResultPageBase resultPage = resultSearchPage.clickFilterOfCard("Mail");
        List<String> statuses = resultPage.getDeliveryStatuses();
        List<String> messages = resultPage.getValidationMessages();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(messages.size(), 0, "Validation message is present for US");
        statuses.forEach(status -> softAssert.assertTrue(status.contains(R.TESTDATA.get("zipCode")), "Product delivery is not " + R.TESTDATA.get("zipCode")));
        softAssert.assertAll();
    }

    @Test(testName = "verify eGiftCard type delivery is email")
    public void verifyDeliveryTypeEGiftCardTest() {
        HomePageBase homePage = new HomePage(getDriver());
        homePage.open();
        LocationPopUpBase locationPopUp = homePage.getLocationPopUp();
        locationPopUp.clickNotChangeButton();
        String actualLocation = homePage.getActualDeliveryLocation();
        Assert.assertEquals(actualLocation, R.TESTDATA.get("impossibleDelivery"), "The location is not "+ R.TESTDATA.get("impossibleDelivery"));
        MenuBarBase menuBar = homePage.getMenuBar();
        GiftCardPageBase giftCardPage = menuBar.clickGiftCardTabButton();
        giftCardPage.clickOccasionButton();
        ResultPageBase resultPage = giftCardPage.clickTypeOfCard("EGIFT");
        List<String> types = resultPage.getDeliveryTypes();

        SoftAssert softAssert = new SoftAssert();
        types.forEach(typeText -> softAssert.assertEquals(typeText, "Email", "Delivery type is not email"));
        softAssert.assertAll();
    }
}
