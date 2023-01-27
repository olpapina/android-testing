package com.solvd.mobiletesting.android.element;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.element.TopDropMenuBase;
import com.solvd.mobiletesting.base.page.GiftCardPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TopDropMenuBase.class)
public class TopDropMenu extends TopDropMenuBase implements IMobileUtils {

    @FindBy(xpath = "//*[@class='hmenu-item']//*[contains(text(),'Gift Cards')]")
    private ExtendedWebElement giftCardButton;

    @FindBy(xpath = "//*[contains(@class,'hmenu-compressed-btn')]//*[contains(text(),'see all')]")
    private List<ExtendedWebElement> seeAllButtons;
    public TopDropMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public GiftCardPageBase clickGiftCardButton() {
        seeAllButtons.forEach(button -> {
            button.scrollTo();
            button.clickIfPresent(10);
        });
        giftCardButton.scrollTo();
        tap(giftCardButton);
        return initPage(getDriver(), GiftCardPageBase.class);
    }
}
