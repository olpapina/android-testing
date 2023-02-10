package com.solvd.mobiletesting.android.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.page.ProductPageBase;
import com.solvd.mobiletesting.base.page.ResultPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ResultPageBase.class)
public class ResultPage extends ResultPageBase {

    @FindBy(xpath = "//*[contains(@title,'product-image') and contains(@href,'Amazon')]")
    private List<ExtendedWebElement> resultLinks;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<String> getValidationMessages() {
        return resultLinks.stream()
                .map(resultLink -> {
                    int linkNumber = (int) (Math.random() * resultLinks.size());
                    resultLinks.get(linkNumber).click();
                    ProductPageBase productPage = new ProductPage(getDriver());
                    String message = productPage.getDeliveryValidationMessageText();
                    getDriver().navigate().back();
                    return message;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Boolean> checkButtonStatus(String type) {
        return resultLinks.stream()
                .map(resultLink -> {
                    int linkNumber = (int) (Math.random() * resultLinks.size());
                    resultLinks.get(linkNumber).click();
                    ProductPageBase productPage = new ProductPage(getDriver());
                    Boolean status = productPage.isAddToCartButton(type);
                    getDriver().navigate().back();
                    return status;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getDeliveryStatuses() {
        return resultLinks.stream()
                .map(resultLink -> {
                    int linkNumber = (int) (Math.random() * resultLinks.size());
                    resultLinks.get(linkNumber).click();
                    ProductPageBase productPage = new ProductPage(getDriver());
                    String statusesText = productPage.getDeliveryStatus();
                    getDriver().navigate().back();
                    return statusesText;
                })
                .collect(Collectors.toList());
    }

    public List<String> getDeliveryTypes() {
        return resultLinks.stream()
                .map(resultLink -> {
                    int linkNumber = (int) (Math.random() * resultLinks.size());
                    resultLinks.get(linkNumber).click();
                    ProductPageBase productPage = new ProductPage(getDriver());
                    String typesText = productPage.getDeliveryType();
                    getDriver().navigate().back();
                    return typesText;
                })
                .collect(Collectors.toList());
    }
}
