package com.solvd.mobiletesting.android.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.page.EnterZipCodePageBase;
import com.solvd.mobiletesting.base.page.HomePageBase;
import com.solvd.mobiletesting.base.page.SelectLocationPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SelectLocationPageBase.class)
public class SelectLocationPage extends SelectLocationPageBase implements IMobileUtils {

    @FindBy(xpath = "//*[@id='GLUXMobilePostalCodeLink']")
    private ExtendedWebElement enterZipCodeButton;

    @FindBy(xpath = "//*[@id='GLUXMobileCountryLink']")
    private ExtendedWebElement outsideUSButton;

    @FindBy(xpath = "//*[@class='a-box-inner']//*[contains(text(),'Belarus')]")
    private ExtendedWebElement selectBelarus;

    public SelectLocationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public EnterZipCodePageBase clickEnterZipCodeButton() {
        if (enterZipCodeButton.isElementPresent() & enterZipCodeButton.isClickable()) {
            swipe(enterZipCodeButton);
            tap(enterZipCodeButton);
        }
        return initPage(getDriver(), EnterZipCodePageBase.class);
    }

    @Override
    public HomePageBase selectCountry() {
        if (outsideUSButton.isElementPresent() & outsideUSButton.isClickable()) {
            swipe(outsideUSButton);
            tap(outsideUSButton);
        }
        selectBelarus.clickIfPresent(5L);
        return initPage(getDriver(), HomePageBase.class);
    }
}
