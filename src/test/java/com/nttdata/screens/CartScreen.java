package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.core.Serenity.takeScreenshot;

public class CartScreen extends PageObject {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement titleCart;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement quantityCart;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private WebElement priceUnitCart;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/totalPriceTV")
    private WebElement priceTotalCart;


    public String getTitleCart() {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(50));
            wait.until(ExpectedConditions.visibilityOf(titleCart));
            return this.titleCart.getText();
        } catch (Exception e) {
            takeScreenshot();
            return null;
        }
    }

    public int getQuantityCartV() {
        return Integer.parseInt(this.quantityCart.getText());
    }

    public double getPriceUnitCart() {
        return Double.parseDouble(this.priceUnitCart.getText().replaceAll("[^0-9.]", "").trim());
    }

    public double getPriceTotalCart() {
        return Double.parseDouble(this.priceTotalCart.getText().replaceAll("[^0-9.]", "").trim());
    }
}
