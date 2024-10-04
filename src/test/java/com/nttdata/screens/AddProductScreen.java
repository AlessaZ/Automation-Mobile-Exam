package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.core.Serenity.takeScreenshot;

public class AddProductScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/noTV\"]")
    private WebElement quantity;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    private WebElement btnAddCart;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/minusIV")
    private WebElement decreaseButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private WebElement increaseButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartRL")
    private WebElement ivCart;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartTV")
    private WebElement quantityCart;

    public void typeQuantity(int quantityWanted) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(quantity));
        int currentQuantity = Integer.parseInt(quantity.getText());

        while (currentQuantity != quantityWanted) {
            if (currentQuantity < quantityWanted) {
                increaseButton.click();
                currentQuantity++;
            } else {
                decreaseButton.click();
                currentQuantity--;
            }
        }
    }

    public void clickBtnAddCart() {
        this.btnAddCart.click();
    }

    public int getQuantityCart() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(quantityCart));
            return Integer.parseInt(this.quantityCart.getText());
        } catch (Exception e) {
            takeScreenshot();
            return 0;
        }
    }

    public void clickCart() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(ivCart));
        this.ivCart.click();
    }

}
