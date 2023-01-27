package com.solvd.mobiletesting.android.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.page.GiftCardPageBase;
import com.solvd.mobiletesting.base.page.ResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GiftCardPageBase.class)
public class GiftCardPage extends GiftCardPageBase {

    @FindBy(xpath = "//*[@class='acsUxWidget']//*[contains(@class,'bxc-grid--mobile-middle-spacing-none')]//*[contains(@class,'bxc-grid__image--light')]")
    private List<ExtendedWebElement> occasionButtons;

    @FindBy(xpath = "//*[@id='bxc-grid__button bxc-grid__button--r-c2']")
    private ExtendedWebElement mailButton;

    @FindBy(xpath = "//*[@id='bxc-grid__button bxc-grid__button--r-c1']")
    private ExtendedWebElement eGiftCardButton;

    @FindBy(xpath = "//*[@id='bxc-grid__button bxc-grid__button--r-c3']")
    private ExtendedWebElement printAtHomeButton;

    public GiftCardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOccasionButton() {
        occasionButtons.get((int) (Math.random() * occasionButtons.size())).click(5L);
    }

    @Override
    public ResultPageBase clickTypeOfCard(String type) {
        switch (type) {
            case "MAIL":
                mailButton.click(5L);
                break;
            case "EGIFT":
                eGiftCardButton.click(5L);
                break;
            default:
                printAtHomeButton.click(5L);
                break;
        }
        return initPage(getDriver(), ResultPageBase.class);
    }
}
