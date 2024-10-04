Feature: Añadir producto al carrito

  @AddProductSuccess
  Scenario Outline:  Añadir satisfactoriamente un producto al carrito
    Given estoy en la aplicación de SauceLabs
    And valido que carguen correctamente los productos en la galeria
    When agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
    Then valido el carrito de compra actualice correctamente con las unidades <UNIDADES>
    Examples:
      | PRODUCTO                        | UNIDADES |
      | Sauce Labs Backpack             | 1        |
      | Sauce Labs Backpack             | 2        |
      | Sauce Labs Bolt T-Shirt         | 1        |
      | Sauce Labs Bike Light           | 2        |