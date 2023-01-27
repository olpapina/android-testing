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

    @FindBy(xpath = "//*[@class='a-button-inner']//*[@id='gc-order-form-atc']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//*[@class='a-button-inner']//*[@id='gc-order-form-bn']")
    private ExtendedWebElement buyNowButton;

    @FindBy(xpath = "//*[@id='mir-layout-DELIVERY_BLOCK-slot-PRIMARY_DELIVERY_MESSAGE_LARGE']")
    private ExtendedWebElement inactiveAddToCartButton;

    @FindBy(xpath = "//*[@id='contextualIngressPt']")
    private ExtendedWebElement deliveryLocation;

    @FindBy(xpath = "//*[@id='gc-delivery-mechanism-button-Email-announce']")
    private ExtendedWebElement deliveryType;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getDeliveryValidationMessage() {
        return deliveryValidationMessage.getText();
    }

    @Override
    public Boolean isAddToCartButtonInactive() {
        return inactiveAddToCartButton.isElementPresent();
    }

    @Override
    public String getDeliveryStatus() {
        return deliveryLocation.getText();
    }

    @Override
    public String getDeliveryType() {
        return deliveryType.getText();
    }


}
