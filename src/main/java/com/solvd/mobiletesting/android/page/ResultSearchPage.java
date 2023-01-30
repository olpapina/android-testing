package com.solvd.mobiletesting.android.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.page.ResultPageBase;
import com.solvd.mobiletesting.base.page.ResultSearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ResultSearchPageBase.class)
public class ResultSearchPage extends ResultSearchPageBase implements IMobileUtils {

    @FindBy(xpath = "//*[@id='question-answer-1-expander-button-Physical Gift Card']")
    private ExtendedWebElement mailButton;

    @FindBy(xpath = "//*[contains(@class,'sf-filter-section')]//*[contains(text(),'eGift Card')]")
    private ExtendedWebElement eGiftCardButton;

    @FindBy(xpath = "//*[contains(@class,'sf-filter-section')]//*[contains(text(),'Amazon')]")
    private ExtendedWebElement amazonButton;

    @FindBy(xpath = "//*[contains(@class,'sf-rib-all-filters')]//*[contains(text(),'Filters')]")
    private ExtendedWebElement filterButton;

    public ResultSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ResultPageBase clickFilterOfCard(String type) {
        switch (type) {
            case "Mail":
                tap(mailButton);
                break;
            case "eGIFT":
                eGiftCardButton.scrollTo();
                eGiftCardButton.click(5L);
                break;
            default:
                amazonButton.click(5L);
                break;
        }
        return initPage(getDriver(), ResultPageBase.class);
    }
}
