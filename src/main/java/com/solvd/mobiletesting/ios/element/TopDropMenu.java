package com.solvd.mobiletesting.ios.element;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.element.TopDropMenuBase;
import com.solvd.mobiletesting.base.page.GiftCardPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = TopDropMenuBase.class)
public class TopDropMenu extends TopDropMenuBase implements IMobileUtils {

    @FindBy(xpath = "//*[contains(@href,'gp') and contains(text(),'Gift Cards')]")
    private List<ExtendedWebElement> giftCardButtons;

    @FindBy(xpath = "//*[contains(@class,'hmenu-compressed-btn')]//*[contains(text(),'see all')]")
    private List<ExtendedWebElement> seeAllButtons;

    public TopDropMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public GiftCardPageBase clickGiftCardButton() {
        seeAllButtons.get(0).clickIfPresent();
        giftCardButtons.get(0).clickIfPresent(5L);
        return initPage(getDriver(), GiftCardPageBase.class);
    }
}
