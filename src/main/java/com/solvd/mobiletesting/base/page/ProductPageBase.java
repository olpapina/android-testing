package com.solvd.mobiletesting.base.page;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getDeliveryValidationMessageText();

    public abstract Boolean isAddToCartButton(String type);

    public abstract String getDeliveryStatus();

    public abstract String getDeliveryType();
}
