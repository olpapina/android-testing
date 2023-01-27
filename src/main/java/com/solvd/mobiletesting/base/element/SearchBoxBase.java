package com.solvd.mobiletesting.base.element;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.mobiletesting.base.page.ResultSearchPageBase;
import org.openqa.selenium.WebDriver;

public abstract class SearchBoxBase extends AbstractPage {
    public SearchBoxBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeSearchedProduct();

    public abstract ResultSearchPageBase clickSearchButton();
}
