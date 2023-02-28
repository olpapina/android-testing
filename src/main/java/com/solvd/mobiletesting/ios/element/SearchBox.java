package com.solvd.mobiletesting.ios.element;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.element.SearchBoxBase;
import com.solvd.mobiletesting.base.page.ResultSearchPageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SearchBoxBase.class)
public class SearchBox extends SearchBoxBase implements IMobileUtils {

    @FindBy(xpath = "//*[contains(@class,'nav-search-field')]//*[contains(@class,'nav-progressive-attribute')]")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//*[contains(@class,'nav-search-submit')]")
    private ExtendedWebElement searchButton;

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeSearchedProduct() {
        searchField.type(R.TESTDATA.get("searchText"));
    }

    @Override
    public ResultSearchPageBase clickSearchButton() {
        tap(searchButton);
        return initPage(getDriver(), ResultSearchPageBase.class);
    }
}
