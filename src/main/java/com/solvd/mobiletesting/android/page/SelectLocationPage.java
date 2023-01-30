package com.solvd.mobiletesting.android.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.page.EnterZipCodePageBase;
import com.solvd.mobiletesting.base.page.SelectLocationPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SelectLocationPageBase.class)
public class SelectLocationPage extends SelectLocationPageBase implements IMobileUtils {

    @FindBy(xpath = "//*[@id='GLUXMobilePostalCodeLink']")
    private ExtendedWebElement enterZipCodeButton;

    public SelectLocationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public EnterZipCodePageBase clickEnterZipCodeButton() {
        if (enterZipCodeButton.isElementPresent() & enterZipCodeButton.isClickable()) {
            tap(enterZipCodeButton);
        }
        return initPage(getDriver(), EnterZipCodePageBase.class);
    }
}
