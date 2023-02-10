package com.solvd.mobiletesting.base.page;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ResultPageBase extends AbstractPage {

    public ResultPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<String> getValidationMessages();

    public abstract List<Boolean> checkButtonStatus(String type);

    public abstract List<String> getDeliveryStatuses();

    public abstract List<String> getDeliveryTypes();
}

