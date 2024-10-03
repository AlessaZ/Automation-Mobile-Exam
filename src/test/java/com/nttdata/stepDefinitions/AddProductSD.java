package com.nttdata.stepDefinitions;

import com.nttdata.steps.ProductSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class AddProductSD {

    @Steps
    ProductSteps productSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeSauceLabs() {
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        productSteps.validateTitleProduct();
        productSteps.validateLoadProducts();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoUNIDADESDelSiguienteProducto(int unidades, String producto) {
        productSteps.searchProductByName(producto);
        productSteps.addQuantityProduct(unidades);
    }

    @Then("valido el carrito de compra actualice correctamente con las {int}")
    public void validoElCarritoDeCompraActualiceCorrectamenteConLas(int unidades) {
        productSteps.validateQuantityCart(unidades);
        productSteps.cartView();
        productSteps.validateTitleCart();
        productSteps.validateQuantityCartV(unidades);
        //productSteps.validateTotalPriceCart();
    }
}
