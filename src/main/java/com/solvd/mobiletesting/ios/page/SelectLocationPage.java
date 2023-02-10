package com.solvd.mobiletesting.ios.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.page.EnterZipCodePageBase;
import com.solvd.mobiletesting.base.page.SelectLocationPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SelectLocationPageBase.class)
public class SelectLocationPage extends SelectLocationPageBase implements IMobileUtils {

    @FindBy(xpath = "//*[contains(@class,'a-spacing-medium')]//*[contains(text(),'code')]")
    private ExtendedWebElement enterZipCodeButton;

    public SelectLocationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public EnterZipCodePageBase clickEnterZipCodeButton() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='GLUXMobilePostalCodeLink']")), 5L);
        tap(90, 750);
        return initPage(getDriver(), EnterZipCodePageBase.class);
    }
}
