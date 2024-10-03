package com.nttdata.steps;

import com.nttdata.screens.AddProductScreen;
import com.nttdata.screens.CartScreen;
import com.nttdata.screens.ProductScreen;
import org.junit.Assert;

public class ProductSteps {

    ProductScreen productScreen;
    AddProductScreen addProductScreen;
    CartScreen cartScreen;

    public void validateTitleProduct() {
        Assert.assertEquals("Mensaje de error es incorrecto", productScreen.getProductTitle(),"Products");
    }

    public void validateLoadProducts(){
        Assert.assertTrue("No se cargó correctamente la página",productScreen.loadProducts());
    }

    public void searchProductByName(String productName){
        productScreen.clickProductByName(productName);
    }

    public void addQuantityProduct(int quantity){
        addProductScreen.typeQuantity(quantity);
        addProductScreen.clickBtnAddCart();
    }

    public void validateQuantityCart(int quantity){
        Assert.assertEquals("No es el valor correcto del carrito",addProductScreen.getQuantityCart(),String.valueOf(quantity));
    }

    public void cartView(){
        addProductScreen.clickCart();
    }

    public void validateTitleCart(){
        Assert.assertEquals("No cargó página Cart",cartScreen.getTitleCart(),"Cart");
    }

    public void validateQuantityCartV(int quantity){
        Assert.assertEquals("No es el valor correcto del carrito",cartScreen.getQuantityCart(),quantity);
    }

    public void validateTotalPriceCart(){
        int quantity = cartScreen.getQuantityCart();
        double price = cartScreen.getPriceUnitCart();
        double totalPriceExpected = quantity * price;
        double totalPrice = cartScreen.getPriceTotalCart();
        Assert.assertEquals("No está calculando correctamente el total",totalPriceExpected,totalPrice,0.01);
    }

}
