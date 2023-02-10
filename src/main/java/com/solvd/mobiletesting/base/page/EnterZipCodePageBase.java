package com.solvd.mobiletesting.base.page;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class EnterZipCodePageBase extends AbstractPage {
    public EnterZipCodePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void enterZipCode();

    public abstract HomePageBase clickApplyButton();
}
