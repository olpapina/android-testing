package com.solvd.mobiletesting.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.mobiletesting.base.AppBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AppBase.class)
public class ChromeApp extends AppBase {

    @FindBy(id = "toolbar_buttons")
    private ExtendedWebElement toolbarButton;

    @FindBy(id = "button_two")
    private ExtendedWebElement bookmarkButton;

    @FindBy(id = "menu_item_text")
    private List<ExtendedWebElement> toolbarMenuButtons;

    @FindBy(id = "action_bar_root")
    private List<ExtendedWebElement> tabActionButtons;

    @FindBy(id = "tab_switcher_button")
    private ExtendedWebElement tabSwitchButton;

    @FindBy(id = "search_box_text")
    private ExtendedWebElement googleSearchField;

    @FindBy(id = "omnibox_results_container")
    private List<ExtendedWebElement> containerResults;

    @FindBy(id = "compositor_view_holder")
    private ExtendedWebElement filterResult;

    public ChromeApp(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickSwitchTabButton() {
        tap(tabSwitchButton);
    }

    @Override
    public void createNewBookmarkButton(String urlNewSite) {
        toolbarButton.click();
        toolbarMenuButtons.get(0).clickIfPresent(5);
        googleSearchField.type(urlNewSite);

        containerResults.get(0).click();
        filterResult.click();

        toolbarButton.click();
        bookmarkButton.clickIfPresent();
    }

    @Override
    public void clickCloseTab() {
        tap(toolbarMenuButtons.get(0));
    }

    @Override
    public void createNewTab() {
        tap(toolbarMenuButtons.get(1));
    }

}
