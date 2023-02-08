package com.solvd.mobiletesting.android.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.page.EnterZipCodePageBase;
import com.solvd.mobiletesting.base.page.HomePageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = EnterZipCodePageBase.class)
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
        waitUntil(ExpectedConditions.visibilityOfElementLocated(By.id("GLUXZipUpdateInput")), 5L);
        enterZipCodeField.type(R.TESTDATA.get("zipCode"));
    }

    @Override
    public HomePageBase clickApplyButton() {
        applyButton.click(5L);
        return initPage(getDriver(), HomePageBase.class);
    }
}
