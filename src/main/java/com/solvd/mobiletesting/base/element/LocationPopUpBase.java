package com.solvd.mobiletesting.base.element;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.mobiletesting.base.page.SelectLocationPageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class LocationPopUpBase extends AbstractPage implements IMobileUtils {

    public LocationPopUpBase(WebDriver driver) {
        super(driver);
    }

    public abstract SelectLocationPageBase clickChangeAddressButton();

    public abstract void clickNotChangeButton();
}
