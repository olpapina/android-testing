package com.solvd.mobiletesting.base.page;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ResultSearchPageBase extends AbstractPage {
    public ResultSearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ResultPageBase clickFilterOfCard(String type);
}
