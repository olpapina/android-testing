package com.solvd.mobiletesting.base.element;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.mobiletesting.base.page.GiftCardPageBase;
import org.openqa.selenium.WebDriver;

public abstract class MenuBarBase extends AbstractPage {
    public MenuBarBase(WebDriver driver) {
        super(driver);
    }

    public abstract GiftCardPageBase clickGiftCardTabButton();
}
