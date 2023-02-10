package com.solvd.mobiletesting.base.element;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.mobiletesting.base.page.GiftCardPageBase;
import org.openqa.selenium.WebDriver;

public abstract class TopDropMenuBase extends AbstractPage {
    public TopDropMenuBase(WebDriver driver) {
        super(driver);
    }

    public abstract GiftCardPageBase clickGiftCardButton();
}
