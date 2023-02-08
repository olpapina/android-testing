package com.solvd.mobiletesting.android.element;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.element.MenuBarBase;
import com.solvd.mobiletesting.base.page.GiftCardPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuBarBase.class)
public class MenuBar extends MenuBarBase {

    @FindBy(xpath = "//*[@id='nav-gwbar']//*[contains(@href,'giftcards')]")
    private ExtendedWebElement giftCardTabButton;

    public MenuBar(WebDriver driver) {
        super(driver);
    }

    @Override
    public GiftCardPageBase clickGiftCardTabButton() {
        giftCardTabButton.clickIfPresent(5L);
        return initPage(getDriver(), GiftCardPageBase.class);
    }
}
