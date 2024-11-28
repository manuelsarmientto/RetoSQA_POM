package com.co.homecenter.stepDefinitions;


import com.co.homecenter.driver.SeleniumWebDriver;
import com.co.homecenter.steps.CarritoSteps;
import com.co.homecenter.steps.ValidarCarritoSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class AgregarProductoAlCarritoStepDefinitions {

    @Steps
    CarritoSteps carrito = new CarritoSteps();

    @Steps
    ValidarCarritoSteps validar = new ValidarCarritoSteps();

    @Dado("que me encuentro en la pagina de HomeCenter")
    public void queMeEncuentroEnLaPaginaDeHomeCenter() {
        SeleniumWebDriver.chromeDrive("https://homecenter.com.co/");
    }

    @Cuando("realizo la busqueda de un producto")
    public void realizoLaBusquedaDeUnProducto() {
        carrito.BusquedaProducto();
        carrito.SeleccionarProducto();
    }

    @Cuando("lo agrego al carrito")
    public void loAgregoAlCarrito() {
        carrito.AgregarProductoAlCarrito();
    }

    @Entonces("valido que haya sido agregado correctamente")
    public void validoQueHayaSidoAgregadoCorrectamente() {
        validar.obtenerInfoProducto();
        SeleniumWebDriver.driver.close();
    }
}