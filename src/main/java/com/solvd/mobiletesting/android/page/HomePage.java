package com.solvd.mobiletesting.android.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.element.LocationPopUpBase;
import com.solvd.mobiletesting.base.element.MenuBarBase;
import com.solvd.mobiletesting.base.element.SearchBoxBase;
import com.solvd.mobiletesting.base.element.TopDropMenuBase;
import com.solvd.mobiletesting.base.page.HomePageBase;
import com.solvd.mobiletesting.base.page.SelectLocationPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//*[@id='glow-ingress-single-line']")
    private ExtendedWebElement deliveryLocationText;

    @FindBy(xpath = "//*[@id='glow-ingress-block']")
    private ExtendedWebElement deliveryLocationIcon;

    @FindBy(xpath = "//*[@id='nav-hamburger-menu']")
    private ExtendedWebElement topMenuButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LocationPopUpBase getLocationPopUp() {
        return initPage(getDriver(), LocationPopUpBase.class);
    }

    @Override
    public MenuBarBase getMenuBar() {
        return initPage(getDriver(), MenuBarBase.class);
    }

    @Override
    public String getActualDeliveryLocation() {
        waitUntil(ExpectedConditions.visibilityOfAllElements(), 10L);
        String location = "";
        if (deliveryLocationText.isElementPresent(5L)) {
            location = deliveryLocationText.getText();
        }
        return location;
    }

    @Override
    public SearchBoxBase getSearchBox() {
        return initPage(getDriver(), SearchBoxBase.class);
    }

    @Override
    public TopDropMenuBase clickTopMenu() {
        topMenuButton.click(5L);
        return initPage(getDriver(), TopDropMenuBase.class);
    }

    @Override
    public SelectLocationPageBase clickActualLocation() {
        deliveryLocationIcon.click();
        return initPage(getDriver(), SelectLocationPageBase.class);
    }
}
