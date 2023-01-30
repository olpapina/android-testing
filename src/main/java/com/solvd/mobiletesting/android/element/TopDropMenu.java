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

    @FindBy(xpath = "//*[@href='/gp/browse.html?node=2238192011&ref_=navm_em__mw_cs_gc_0_1_1_22']")
    private ExtendedWebElement giftCardButton;

    @FindBy(xpath = "//*[contains(@class,'hmenu-compressed-btn')]//*[contains(text(),'see all')]")
    private List<ExtendedWebElement> seeAllButtons;

    public TopDropMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public GiftCardPageBase clickGiftCardButton() {
        seeAllButtons.get(0).clickIfPresent();
        giftCardButton.clickIfPresent(5L);
        return initPage(getDriver(), GiftCardPageBase.class);
    }
}
