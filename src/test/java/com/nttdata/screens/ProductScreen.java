package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.saucelabs.mydemoapp.android:id/productIV']")
    private List<WebElement> products;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]")
    private WebElement titleProductPage;

    public boolean loadProducts() {
        return !products.isEmpty();
    }

    public String getProductTitle(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        // Esperar hasta que el elemento se encuentre
        wait.until(ExpectedConditions.visibilityOf(titleProductPage));
        return titleProductPage.getText();
    }

    public void clickProductByName(String productName){
        for (WebElement product : products) {
            String contentDescription = product.getAttribute("content-desc");
            if (contentDescription.equalsIgnoreCase(productName)) {
                product.click();
                break;
            }
        }
    }

}
