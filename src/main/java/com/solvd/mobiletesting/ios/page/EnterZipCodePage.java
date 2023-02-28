package com.solvd.mobiletesting.ios.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.page.EnterZipCodePageBase;
import com.solvd.mobiletesting.base.page.HomePageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = EnterZipCodePageBase.class)
public class EnterZipCodePage extends EnterZipCodePageBase {

    @FindBy(xpath = "//*[@class='GLUX_Full_Width_Mobile_Zip' and @id='GLUXZipUpdateInput']")
    private ExtendedWebElement enterZipCodeField;

    @FindBy(xpath = "//*[@id='GLUXMobileHiddenZipCode']//*[@class='a-button-input']")
    private ExtendedWebElement applyButton;

    public EnterZipCodePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterZipCode() {
        if (enterZipCodeField.isElementPresent(5L)) {
            enterZipCodeField.type(R.TESTDATA.get("zipCode"));
        }
    }

    @Override
    public HomePageBase clickApplyButton() {
        applyButton.click(5L);
        return initPage(getDriver(), HomePageBase.class);
    }
}
