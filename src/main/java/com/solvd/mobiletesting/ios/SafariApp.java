package com.solvd.mobiletesting.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.mobiletesting.base.AppBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AppBase.class)
public class SafariApp extends AppBase {
    public SafariApp(WebDriver driver) {
        super(driver);
    }

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Open\"`]")
    private ExtendedWebElement openButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Tabs\"`]")
    private ExtendedWebElement tabOverViewButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"New tab\"`]")
    private ExtendedWebElement newTabButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`label == \"Address\"`]")
    private ExtendedWebElement searchField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"go\"`]")
    private ExtendedWebElement goButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Share\"`]")
    private ExtendedWebElement shareButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Add to Favorites\"`]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private ExtendedWebElement addToFavoritesButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Save\"`]")
    private ExtendedWebElement saveButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`label == \"Close\"`][2]")
    private ExtendedWebElement closeTwoTabButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == \"Done\"`]")
    private ExtendedWebElement doneButton;

    public void clickOpenButton() {
        tap(openButton);
    }

    @Override
    public void clickSwitchTabButton() {
        tabOverViewButton.click();

    }

    @Override
    public void createNewBookmarkButton(String urlNewSite) {
        tabOverViewButton.click();
        newTabButton.click();
        searchField.type(urlNewSite);
        tap(goButton);
        tap(shareButton);
        tap(addToFavoritesButton);
        tap(saveButton);
    }

    @Override
    public void clickCloseTab() {
        closeTwoTabButton.click();
        doneButton.click();
    }

    @Override
    public void createNewTab() {
        tap(newTabButton);
    }
}
