package com.solvd.mobiletesting.base.page;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.mobiletesting.base.element.LocationPopUpBase;
import com.solvd.mobiletesting.base.element.MenuBarBase;
import com.solvd.mobiletesting.base.element.SearchBoxBase;
import com.solvd.mobiletesting.base.element.TopDropMenuBase;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LocationPopUpBase getLocationPopUp();

    public abstract MenuBarBase getMenuBar();

    public abstract String getActualDeliveryLocation();

    public abstract SearchBoxBase getSearchBox();

    public abstract TopDropMenuBase clickTopMenu();

    public abstract SelectLocationPageBase clickActualLocation();
}
