package com.solvd.mobiletesting.base.element;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.mobiletesting.base.page.SelectLocationPageBase;
import org.openqa.selenium.WebDriver;

public abstract class LocationPopUpBase extends AbstractPage {

    public LocationPopUpBase(WebDriver driver) {
        super(driver);
    }

    public abstract SelectLocationPageBase clickChangeAddressButton();

    public abstract void clickNotChangeButton();
}
