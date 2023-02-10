package com.solvd.mobiletesting.android.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.page.GiftCardPageBase;
import com.solvd.mobiletesting.base.page.ResultPageBase;
import com.solvd.mobiletesting.base.page.ResultSearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GiftCardPageBase.class)
public class GiftCardPage extends GiftCardPageBase {

    @FindBy(xpath = "//*[@class='acsUxWidget']//*[contains(@class,'bxc-grid--mobile-middle-spacing-none')]//*[contains(@class,'bxc-grid__image--light')]")
    private List<ExtendedWebElement> occasionButtons;

    public GiftCardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ResultSearchPageBase clickOccasionButton() {
        int buttonNumber = (int) (Math.random() * occasionButtons.size());
        occasionButtons.get(buttonNumber).click(5L);
        return initPage(getDriver(), ResultSearchPageBase.class);
    }
}
