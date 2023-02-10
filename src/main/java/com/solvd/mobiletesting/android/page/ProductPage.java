package com.solvd.mobiletesting.android.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.page.ProductPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @FindBy(xpath = "//*[@class='a-spacing-base']//*[@class='a-color-error']")
    private ExtendedWebElement deliveryValidationMessage;

    @FindBy(xpath = "//*[@id='add-to-cart-button']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//*[@id='buy-now-button']")
    private ExtendedWebElement buyNowButton;

    @FindBy(xpath = "//*[@id='exportsUndeliverableMobile-cart-announce']")
    private ExtendedWebElement inactiveAddToCartButton;

    @FindBy(xpath = "//*[@id='contextualIngressPt']")
    private ExtendedWebElement deliveryLocation;

    @FindBy(xpath = "//*[@id='gc-delivery-mechanism-button-Email-announce']")
    private ExtendedWebElement deliveryType;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getDeliveryValidationMessageText() {
        if (deliveryValidationMessage.isElementPresent()) {
            return deliveryValidationMessage.getText();
        } else {
            return null;
        }
    }

    @Override
    public Boolean isAddToCartButton(String type) {
        if (type.equals("inactive")) {
            return inactiveAddToCartButton.isElementPresent();
        } else {
            return addToCartButton.isElementPresent() & buyNowButton.isElementPresent();
        }
    }

    @Override
    public String getDeliveryStatus() {
        return deliveryLocation.getText();
    }

    @Override
    public String getDeliveryType() {
        return deliveryType.getText();
    }

    public ExtendedWebElement getDeliveryValidationMessage() {
        return deliveryValidationMessage;
    }
}
