package com.solvd.mobiletesting.base;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class ChromeAppBase extends AbstractPage implements IMobileUtils {
    public ChromeAppBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickSwitchTabButton();

    public abstract void createNewBookmarkButton(String urlNewSite);

    public abstract void clickCloseTab();

    public abstract void createNewTab();
}
