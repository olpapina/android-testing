package com.solvd.mobiletesting.ios.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.AppBase;
import com.solvd.mobiletesting.base.page.GiftCardPageBase;
import com.solvd.mobiletesting.base.page.ResultSearchPageBase;
import com.solvd.mobiletesting.base.utils.MobileContextUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = GiftCardPageBase.class)
public class GiftCardPage extends GiftCardPageBase implements IMobileUtils {

    @FindBy(xpath = "//*[contains(@class,'bxc-grid--mobile-middle-spacing-none')]//*[contains(@class,'bxc-grid__image--light')]")
    private List<ExtendedWebElement> occasionButtons;

    public GiftCardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ResultSearchPageBase clickOccasionButton() {
        int buttonNumber = (int) (Math.random() * occasionButtons.size());
        if (buttonNumber <= 1) {
            buttonNumber = buttonNumber + 2;
        }
        waitUntil(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'bxc-grid--mobile-middle-spacing-none')]//*[contains(@class,'bxc-grid__image--light')]")), 5L);
        tap(occasionButtons.get(buttonNumber));
        MobileContextUtils contextHelper = new MobileContextUtils();
        contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);
        AppBase safariApp = initPage(getDriver(), AppBase.class);
        safariApp.clickOpenButton();
        contextHelper.switchMobileContext(MobileContextUtils.View.WEB1);
        return initPage(getDriver(), ResultSearchPageBase.class);
    }
}
