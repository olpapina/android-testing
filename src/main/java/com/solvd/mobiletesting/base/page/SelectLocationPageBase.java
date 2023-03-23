package com.solvd.mobiletesting.base.page;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SelectLocationPageBase extends AbstractPage {
    public SelectLocationPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract EnterZipCodePageBase clickEnterZipCodeButton();

    public abstract HomePageBase selectCountry();
}
