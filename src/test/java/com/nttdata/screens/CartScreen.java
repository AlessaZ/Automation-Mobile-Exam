package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

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
        return this.titleCart.getText();
    }

    public int getQuantityCart() {
        return Integer.parseInt(this.quantityCart.getText());
    }

    public double getPriceUnitCart() {
        return Double.parseDouble(this.priceUnitCart.getText().replaceAll("[^0-9.]", "").trim());
    }

    public double getPriceTotalCart() {
        return Double.parseDouble(this.priceTotalCart.getText().replaceAll("[^0-9.]", "").trim());
    }
}
