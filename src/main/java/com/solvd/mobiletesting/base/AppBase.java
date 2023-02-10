package com.solvd.mobiletesting.base;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class AppBase extends AbstractPage implements IMobileUtils {
    public AppBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickSwitchTabButton();

    public abstract void createNewBookmarkButton(String urlNewSite);

    public abstract void clickCloseTab();

    public abstract void createNewTab();

    public void clickOpenButton() {
        //this method use only for safari application
    }
}
