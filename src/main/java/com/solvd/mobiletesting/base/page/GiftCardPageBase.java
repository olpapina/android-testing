package com.solvd.mobiletesting.base.page;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class GiftCardPageBase extends AbstractPage {

    public GiftCardPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOccasionButton();

    public abstract ResultPageBase clickTypeOfCard(String type);
}
